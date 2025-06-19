package com.assembleia.adm.core.service;

import com.assembleia.adm.core.domain.entity.Assembleia;
import com.assembleia.adm.core.port.inbound.AssembleiaServicePort;

import java.util.List;
import java.util.Optional;

public class AssembleiaService implements AssembleiaServicePort {
    @Override
    public Assembleia criar(Assembleia assembleia) {
        return null;
    }

    @Override
    public Assembleia atualizar(Assembleia assembleia) {
        return null;
    }

    @Override
    public Optional<Assembleia> buscarPorId(Long idAssembleia) {
        return Optional.empty();
    }

    @Override
    public List<Assembleia> lista() {
        return null;
    }

    @Override
    public List<Assembleia> lista(String status) {
        return null;
    }
}
