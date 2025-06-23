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
import com.assembleia.adm.shared.util.TimerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class SessaoVotacaoService implements SessaoVotacaoServicePort {

    @Autowired
    private SessaoVotacaoDataPort sessaoVotacaoDataPort;

    @Autowired
    private PautaServicePort pautaServicePort;

    @Autowired
    private VotoServicePort votoServicePort;

    @Autowired
    private TimerUtil timerUtil;

    @Autowired
    private TaskScheduler taskScheduler;

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

        terminoAutomaticoSessaoVotacao(tempoDeSessao, inicioSessaoVotacao.getId());

        return inicioSessaoVotacao;
    }

    @Override
    public SessaoVotacao finalizarSessaoVotacao(Long idSessaoVotacao) {
        //TODO: Validar se ja existe/inicializada
        //TODO: Mudar status para finalizada
        System.out.println(" finalizarSessaoVotacao() FinalizarSessaoVotacao -----------------");

        SessaoVotacao sessaoVotacao = sessaoVotacaoById(idSessaoVotacao);
        System.out.println(" finalizarSessaoVotacao() sessaoVotacao -----------------");
        sessaoVotacao.setTotalVotos(sessaoVotacao.getVotos().size());
        sessaoVotacao.setTotalVotosSim(votoServicePort.totalVotosSim(sessaoVotacao.getId()));
        sessaoVotacao.setTotalVotosNao(votoServicePort.totalVotosNao(sessaoVotacao.getId()));
        sessaoVotacao.setSessaoVotacaoStatus(SessaoVotacaoStatus.FECHADA);

        Optional<SessaoVotacao> sv = sessaoVotacaoDataPort.terminoSessaoVotacao(sessaoVotacao);
        System.out.println(" finalizarSessaoVotacao() FinalizarSessaoVotacao -----------------");

        return sv.orElseThrow();
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

    private void terminoAutomaticoSessaoVotacao(Integer tempoDeSessao, Long idSessaoVotacao){

        System.out.println(" TerminoAutomaticoSessaoVotacao ----- Programar finalização em "+ tempoDeSessao +"-----------------");

        ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
        TimerTask timerTask = new TimerUtil();
        ses.schedule(new TimerTask() {
            @Override
            public void run() {
                finalizarSessaoVotacao(idSessaoVotacao);
            }
        }, Long.valueOf(tempoDeSessao), TimeUnit.MINUTES);

    }

}