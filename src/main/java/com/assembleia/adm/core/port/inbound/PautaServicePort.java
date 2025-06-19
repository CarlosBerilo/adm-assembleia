package com.assembleia.adm.core.port.inbound;

import com.assembleia.adm.core.domain.entity.Pauta;

import java.util.List;
import java.util.Optional;

public interface PautaServicePort {
    Pauta criar(Pauta pauta);

    Pauta atualizar(Pauta pauta);

    Optional<Pauta> buscarPorId(Long idPauta);

    List<Pauta> listaPorAssembleia(Long idAssembleia);
}
