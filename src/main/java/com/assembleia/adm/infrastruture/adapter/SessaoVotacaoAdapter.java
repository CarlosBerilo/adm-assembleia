package com.assembleia.adm.infrastruture.adapter;

import com.assembleia.adm.core.domain.entity.SessaoVotacao;
import com.assembleia.adm.core.port.outbound.SessaoVotacaoDataPort;
import com.assembleia.adm.infrastruture.config.Adapter;
import com.assembleia.adm.infrastruture.repository.SessaoVotacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@Adapter
public class SessaoVotacaoAdapter implements SessaoVotacaoDataPort {

    @Autowired
    private SessaoVotacaoRepository sessaoVotacaoRepository;

    @Override
    public Optional<SessaoVotacao> inicioSessaoVotacao(SessaoVotacao sessaoVotacao) {
        return Optional.of(sessaoVotacaoRepository.save(sessaoVotacao));
    }

    @Override
    public Optional<SessaoVotacao> sessaoVotacaoById(Long idSessaoVotacao) {
        return sessaoVotacaoRepository.findById(idSessaoVotacao);
    }

    @Override
    public Optional<SessaoVotacao> terminoSessaoVotacao(SessaoVotacao sessaoVotacao) {
        sessaoVotacaoRepository.save(sessaoVotacao);
        return sessaoVotacaoRepository.findById(sessaoVotacao.getId());
    }
}
