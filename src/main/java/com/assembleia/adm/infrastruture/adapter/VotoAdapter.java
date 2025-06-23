package com.assembleia.adm.infrastruture.adapter;

import com.assembleia.adm.core.domain.entity.SessaoVotacao;
import com.assembleia.adm.core.domain.entity.Voto;
import com.assembleia.adm.core.domain.enumeration.VotoStatus;
import com.assembleia.adm.core.port.outbound.VotoDataPort;
import com.assembleia.adm.infrastruture.config.Adapter;
import com.assembleia.adm.infrastruture.repository.VotoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Adapter
public class VotoAdapter implements VotoDataPort {

    @Autowired
    private VotoRepository votoRepository;

    @Override
    public void votar(Voto voto) {
        votoRepository.save(voto);
    }

    @Override
    public Integer totalVotos(Long idSessaoVotacao) {
        return votoRepository.findBySessaoVotacao(SessaoVotacao.builder().id(idSessaoVotacao).build()).size();
    }

    @Override
    public Integer totalVotosSim(Long idSessaoVotacao) {
        return votoRepository.findBySessaoVotacaoAndVotoStatus(SessaoVotacao.builder().id(idSessaoVotacao).build(), VotoStatus.SIM).size();
    }

    @Override
    public Integer totalVotosNao(Long idSessaoVotacao) {
        return votoRepository.findBySessaoVotacaoAndVotoStatus(SessaoVotacao.builder().id(idSessaoVotacao).build(), VotoStatus.NAO).size();
    }

    @Override
    public int votoExiste(Long idCooperado, Long idSessaoVotacao) {
        return votoRepository.findByCooperadoAndSessaoVotacao(idCooperado, idSessaoVotacao);
    }


}
