package com.assembleia.adm.core.port.inbound;


import com.assembleia.adm.core.domain.entity.Voto;

public interface VotoServicePort {
    void votar(Voto voto);

    Integer totalVotos(Long idSessaoVotacao);

    Integer totalVotosSim(Long idSessaoVotacao);

    Integer totalVotosNao(Long idSessaoVotacao);
}
