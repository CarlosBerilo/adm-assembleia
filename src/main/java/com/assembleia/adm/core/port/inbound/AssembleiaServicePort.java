package com.assembleia.adm.core.port.inbound;

import com.assembleia.adm.core.domain.entity.Assembleia;
import com.assembleia.adm.core.domain.enumeration.AssembleiaStatus;

import java.util.List;
import java.util.Optional;

public interface AssembleiaServicePort {
    Assembleia criar(Assembleia assembleia);

    Assembleia atualizar(Assembleia assembleia);

    Assembleia buscarPorId(Long idAssembleia);

    List<Assembleia> lista();

    List<Assembleia> lista(AssembleiaStatus assembleiaStatus);

    Assembleia incluirAta(Long idAssembleia,String ata);
}
