package com.assembleia.adm.core.port.outbound;

import com.assembleia.adm.core.domain.entity.Assembleia;
import com.assembleia.adm.core.domain.enumeration.AssembleiaStatus;

import java.util.List;
import java.util.Optional;

public interface AssembleiaDataPort {

    Optional<Assembleia> criar(Assembleia assembleia);

    Optional<Assembleia> atualizar(Assembleia assembleia);

    Optional<Assembleia> buscarPorId(Long idAssembleia);

    List<Assembleia> lista();

    List<Assembleia> lista(AssembleiaStatus assembleiaStatus);

}
