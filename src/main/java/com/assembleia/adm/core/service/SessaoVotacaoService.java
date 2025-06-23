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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
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
                .inicio(horaSessaoVotacao())
                .previsaoTermino(previsaoTerminoSessaoVotacao(tempoDeSessao))
                .sessaoVotacaoStatus(SessaoVotacaoStatus.ABERTA)
                .build()).orElseThrow(() -> new RuntimeException("Error: Sessao Votacao não inicializada"));

        pauta.setSessaoVotacao(inicioSessaoVotacao);
        pautaServicePort.atualizar(pauta);

        timerFinalizarSessaoVotacao(tempoDeSessao);

        return inicioSessaoVotacao;
    }

    @Override
    public SessaoVotacao finalizarSessaoVotacao(Long idSessaoVotacao) {
        //TODO: Validar se ja existe/inicializada
        //TODO: Mudar status para finalizada
        return sessaoVotacaoDataPort.terminoSessaoVotacao(
                    sessaoVotacaoDataPort.sessaoVotacaoById(idSessaoVotacao).map(sessaoVotacao -> {
                        sessaoVotacao.setTermino(horaSessaoVotacao());
                        sessaoVotacao.setTotalVotos(sessaoVotacao.getVotos().size());
                        sessaoVotacao.setTotalVotosSim(contagemVotosSim(sessaoVotacao.getVotos()));
                        sessaoVotacao.setTotalVotosNao(contagemVotosNao(sessaoVotacao.getVotos()));
                        sessaoVotacao.setSessaoVotacaoStatus(SessaoVotacaoStatus.FECHADA);
                        return sessaoVotacao;
                    }).orElseThrow(() -> new RuntimeException("Error: Sessao Votacao finalizada")))
        .orElseThrow(() -> new RuntimeException("Error: Sessao Votacao finalizada"));
    }

    @Override
    public SessaoVotacao sessaoVotacaoById(Long idSessaoVotacao) {
        return sessaoVotacaoDataPort.sessaoVotacaoById(idSessaoVotacao).orElseThrow(() -> new RuntimeException("Error: Sessao Votacao nao encontrada"));
    }

    private Timestamp horaSessaoVotacao(){
        return new Timestamp(System.currentTimeMillis());
    }

    private Timestamp previsaoTerminoSessaoVotacao(Integer tempoDeSessao){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.parse(simpleDateFormat.format(timestamp), formater);
        LocalDateTime localDateTimePrevisto = localDateTime.plusMinutes(tempoDeSessao);
        return Timestamp.valueOf(localDateTimePrevisto);
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

    private void timerFinalizarSessaoVotacao(Integer tempoDeSessao){
        
    }

}