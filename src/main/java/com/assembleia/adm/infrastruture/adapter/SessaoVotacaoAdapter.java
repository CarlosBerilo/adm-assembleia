package com.assembleia.adm.infrastruture.adapter;

import com.assembleia.adm.core.domain.entity.SessaoVotacao;
import com.assembleia.adm.core.port.outbound.SessaoVotacaoDataPort;
import com.assembleia.adm.infrastruture.config.Adapter;
import com.assembleia.adm.infrastruture.repository.SessaoVotacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Adapter
public class SessaoVotacaoAdapter implements SessaoVotacaoDataPort {

    @Autowired
    private SessaoVotacaoRepository sessaoVotacaoRepository;

    @Override
    public SessaoVotacao inicioSessaoVotacao(SessaoVotacao sessaoVotacao) {
        return sessaoVotacaoRepository.save(sessaoVotacao);
    }

    @Override
    public SessaoVotacao terminoSessaoVotacao(SessaoVotacao sessaoVotacao) {
        return sessaoVotacaoRepository.save(sessaoVotacao);
    }
}
