package com.assembleia.adm.core.port.inbound;

import com.assembleia.adm.core.domain.entity.Assembleia;

import java.util.List;
import java.util.Optional;

public interface AssembleiaServicePort {
    Assembleia criar(Assembleia assembleia);

    Assembleia atualizar(Assembleia assembleia);

    Optional<Assembleia> buscarPorId(Long idAssembleia);

    List<Assembleia> lista();

    List<Assembleia> lista(String status);
}
