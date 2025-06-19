package com.assembleia.adm.core.port.outbound;

import com.assembleia.adm.core.domain.entity.SessaoVotacao;

public interface SessaoVotacaoDataPort {
    SessaoVotacao inicioSessaoVotacao(SessaoVotacao sessaoVotacao);

    SessaoVotacao terminoSessaoVotacao(SessaoVotacao sessaoVotacao);
}
