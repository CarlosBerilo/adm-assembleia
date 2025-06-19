package com.assembleia.adm.core.port.outbound;

import com.assembleia.adm.core.domain.entity.Assembleia;
import java.util.List;
import java.util.Optional;

public interface AssembleiaDataPort {

    Assembleia criar(Assembleia assembleia);

    Assembleia atualizar(Assembleia assembleia);

    Optional<Assembleia> buscarPorId(Long idAssembleia);

    List<Assembleia> lista();

    List<Assembleia> lista(String status);

}
