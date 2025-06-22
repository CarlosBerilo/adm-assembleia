package com.assembleia.adm.core.service;

import com.assembleia.adm.core.domain.entity.Pauta;
import com.assembleia.adm.core.domain.entity.SessaoVotacao;
import com.assembleia.adm.core.domain.enumeration.SessaoVotacaoStatus;
import com.assembleia.adm.core.port.inbound.SessaoVotacaoServicePort;
import com.assembleia.adm.core.port.inbound.VotoServicePort;
import com.assembleia.adm.core.port.outbound.PautaDataPort;
import com.assembleia.adm.core.port.outbound.SessaoVotacaoDataPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
public class SessaoVotacaoService implements SessaoVotacaoServicePort {

    @Autowired
    private SessaoVotacaoDataPort sessaoVotacaoDataPort;

    @Autowired
    private PautaDataPort pautaDataPort;

    @Autowired
    private VotoServicePort votoServicePort;

    /**
     * Erro ao iniciar uma ja existente "org.postgresql.util.PSQLException: ERROR: duplicate key value violates unique constraint"
     *
     * @param tempoDeSessao
     * @param idPauta
     * @return
     */
    @Override
    public SessaoVotacao iniciarSessaoVotacao(Integer tempoDeSessao, Long idPauta) {
        //TODO: Validar se ja existe/inicializada "Sessão de votacao já inicializada"
        //TODO: Validar se ja existe/finalizada "Sessão de votacao já finalizada"

        if(tempoDeSessao == null) tempoDeSessao = 1;
        SessaoVotacao inicioSessaoVotacao = sessaoVotacaoDataPort.inicioSessaoVotacao(SessaoVotacao.builder()
                .pauta(Pauta.builder().id(idPauta).build())
                .inicio(horaSessaoVotacao())
                .previsaoTermino(previsaoTerminoSessaoVotacao(tempoDeSessao))
                .sessaoVotacaoStatus(SessaoVotacaoStatus.ABERTA)
                .build());
        Pauta pauta = pautaDataPort.buscarPorId(idPauta).get();
        pauta.setSessaoVotacao(inicioSessaoVotacao);
        pautaDataPort.atualizar(pauta);
        return inicioSessaoVotacao;
    }

    @Override
    public SessaoVotacao finalizarSessaoVotacao(Long idSessaoVotacao) {
        //TODO: Validar se ja existe/inicializada
        //TODO: Mudar status para finalizada

        return sessaoVotacaoDataPort.terminoSessaoVotacao(
                    sessaoVotacaoDataPort.sessaoVotacaoById(idSessaoVotacao).map(sessaoVotacao -> {
                        sessaoVotacao.setTermino(horaSessaoVotacao());
                        sessaoVotacao.setTotalVotos(votoServicePort.totalVotos(sessaoVotacao.getId()));
                        sessaoVotacao.setTotalVotosSim(votoServicePort.totalVotosSim(sessaoVotacao.getId()));
                        sessaoVotacao.setTotalVotosNao(votoServicePort.totalVotosNao(sessaoVotacao.getId()));
                        sessaoVotacao.setSessaoVotacaoStatus(SessaoVotacaoStatus.FECHADA);
                        return sessaoVotacao;
                    }).get())
        .get();
    }

    @Override
    public SessaoVotacao sessaoVotacaoById(Long idSessaoVotacao) {
        return sessaoVotacaoDataPort.sessaoVotacaoById(idSessaoVotacao).get();
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

}