package com.assembleia.adm.core.port.outbound;

import com.assembleia.adm.core.domain.entity.Pauta;

import java.util.List;
import java.util.Optional;

public interface PautaDataPort {

    Pauta criar(Pauta pauta);

    Pauta atualizar(Pauta pauta);

    Optional<Pauta> buscarPorId(Long idPauta);

    List<Pauta> listaPorAssembleia(Long idAssembleia);
}
