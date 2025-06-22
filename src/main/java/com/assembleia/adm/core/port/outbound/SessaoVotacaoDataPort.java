package com.assembleia.adm.core.port.outbound;

import com.assembleia.adm.core.domain.entity.SessaoVotacao;

import java.util.Optional;

public interface SessaoVotacaoDataPort {
    SessaoVotacao inicioSessaoVotacao(SessaoVotacao sessaoVotacao);

    Optional<SessaoVotacao> terminoSessaoVotacao(SessaoVotacao sessaoVotacao);

    Optional<SessaoVotacao> sessaoVotacaoById(Long idSessaoVotacao);
}
