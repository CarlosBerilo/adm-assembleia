package com.assembleia.adm.core.service;

import com.assembleia.adm.core.domain.entity.Pauta;
import com.assembleia.adm.core.domain.entity.SessaoVotacao;
import com.assembleia.adm.core.domain.entity.Voto;
import com.assembleia.adm.core.domain.enumeration.SessaoVotacaoStatus;
import com.assembleia.adm.core.domain.enumeration.VotoStatus;
import com.assembleia.adm.core.port.inbound.PautaServicePort;
import com.assembleia.adm.core.port.inbound.SessaoVotacaoServicePort;
import com.assembleia.adm.core.port.inbound.VotoServicePort;
import com.assembleia.adm.core.port.outbound.SessaoVotacaoDataPort;
import com.assembleia.adm.shared.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class SessaoVotacaoService implements SessaoVotacaoServicePort {

    @Autowired
    private SessaoVotacaoDataPort sessaoVotacaoDataPort;

    @Autowired
    private PautaServicePort pautaServicePort;

    @Autowired
    private VotoServicePort votoServicePort;


    @Override
    public SessaoVotacao iniciarSessaoVotacao(Integer tempoDeSessao, Long idPauta) {
        Pauta pauta = pautaServicePort.buscarPorId(idPauta);

        if(tempoDeSessao == null && tempoDeSessao == 0) tempoDeSessao = 1;


        SessaoVotacao inicioSessaoVotacao = sessaoVotacaoDataPort.inicioSessaoVotacao(SessaoVotacao.builder()
                .pauta(Pauta.builder().id(idPauta).build())
                .inicio(TimeUtil.horaSessaoVotacao())
                //.previsaoTermino(TimeUtil.previsaoTerminoSessaoVotacao(tempoDeSessao, dataHoraInicio, ""))
                .sessaoVotacaoStatus(SessaoVotacaoStatus.ABERTA)
                .build()
                ).orElseThrow(() -> new RuntimeException("Error: Sessao Votacao não inicializada"));

        pauta.setSessaoVotacao(inicioSessaoVotacao);
        pautaServicePort.atualizar(pauta);

        terminoProgramadoSessaoVotacao(tempoDeSessao, inicioSessaoVotacao.getId());

        return inicioSessaoVotacao;
    }

    @Override
    public SessaoVotacao finalizarSessaoVotacao(Long idSessaoVotacao) {
        //TODO: Validar se ja existe/inicializada
        //TODO: Mudar status para finalizada

        SessaoVotacao sessaoVotacao = sessaoVotacaoById(idSessaoVotacao);
        sessaoVotacao.setTermino(TimeUtil.horaSessaoVotacao());
        sessaoVotacao.setTotalVotos(sessaoVotacao.getVotos().size());
        sessaoVotacao.setTotalVotosSim(contagemVotosSim(sessaoVotacao.getVotos()));
        sessaoVotacao.setTotalVotosNao(contagemVotosNao(sessaoVotacao.getVotos()));
        sessaoVotacao.setSessaoVotacaoStatus(SessaoVotacaoStatus.FECHADA);

        return sessaoVotacaoDataPort.terminoSessaoVotacao(sessaoVotacao)
                .orElseThrow(() -> new RuntimeException("Sessao Votacao não finalizada"));
    }

    @Override
    public SessaoVotacao sessaoVotacaoById(Long idSessaoVotacao) {
            return sessaoVotacaoDataPort.sessaoVotacaoById(idSessaoVotacao)
                    .orElseThrow(() -> new NoSuchElementException("Sessao Votacao não encontrada"));
    }



    private Integer contagemVotosSim(List<Voto> votos){
        AtomicInteger sim = new AtomicInteger();
        votos.forEach(voto -> {
            if (voto.getVotoStatus() == VotoStatus.SIM)
                sim.getAndIncrement();
        });
        return sim.get();
    }

    private Integer contagemVotosNao(List<Voto> votos){
        AtomicInteger nao = new AtomicInteger();
        votos.forEach(voto -> {
            if (voto.getVotoStatus() == VotoStatus.NAO)
                nao.getAndIncrement();
        });
        return nao.get();
    }

    private void terminoProgramadoSessaoVotacao(Integer tempoDeSessao, Long idSessaoVotacao){
        System.out.println(" TerminoAutomaticoSessaoVotacao ----- Programar finalização em "+ tempoDeSessao +"-----------------");

        ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
        ses.schedule(new TimerTask() {
            @Override
            public void run() {
                finalizarSessaoVotacao(idSessaoVotacao);
            }
        }, Long.valueOf(tempoDeSessao), TimeUnit.MINUTES);

    }

}