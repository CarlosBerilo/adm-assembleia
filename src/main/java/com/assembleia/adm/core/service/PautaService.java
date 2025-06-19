package com.assembleia.adm.core.service;

import com.assembleia.adm.core.domain.entity.Pauta;
import com.assembleia.adm.core.port.inbound.PautaServicePort;

import java.util.List;
import java.util.Optional;

public class PautaService implements PautaServicePort {
    @Override
    public Pauta criar(Pauta pauta) {
        return null;
    }

    @Override
    public Pauta atualizar(Pauta pauta) {
        return null;
    }

    @Override
    public Optional<Pauta> buscarPorId(Long idPauta) {
        return Optional.empty();
    }

    @Override
    public List<Pauta> listaPorAssembleia(Long idAssembleia) {
        return null;
    }
}
