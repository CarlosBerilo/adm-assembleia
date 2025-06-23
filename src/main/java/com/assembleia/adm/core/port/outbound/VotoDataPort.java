package com.assembleia.adm.core.port.outbound;

import com.assembleia.adm.core.domain.entity.Voto;

public interface VotoDataPort {
    void votar(Voto voto);

    Integer totalVotos(Long idSessaoVotacao);

    Integer totalVotosSim(Long idSessaoVotacao);

    Integer totalVotosNao(Long idSessaoVotacao);

    int votoExiste(Long idCooperado, Long idSessaoVotacao);

}
