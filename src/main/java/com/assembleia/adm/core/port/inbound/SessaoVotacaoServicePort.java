package com.assembleia.adm.core.port.inbound;

import com.assembleia.adm.core.domain.entity.SessaoVotacao;

public interface SessaoVotacaoServicePort {

    SessaoVotacao iniciarSessaoVotacao(Integer tempoDeSessao, Long idPauta);

    SessaoVotacao finalizarSessaoVotacao(Long idSessaoVotaca);

    SessaoVotacao sessaoVotacaoById(Long idSessaoVotaca);

}
