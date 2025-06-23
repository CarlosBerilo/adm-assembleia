package com.assembleia.adm.core.port.inbound;

import com.assembleia.adm.core.domain.entity.Pauta;

import java.util.List;

public interface PautaServicePort {
    Pauta criar(Pauta pauta);

    Pauta atualizar(Pauta pauta);

    Pauta buscarPorId(Long idPauta);

    List<Pauta> listaPorAssembleia(Long idAssembleia);
}
