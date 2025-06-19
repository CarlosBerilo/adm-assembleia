package com.assembleia.adm.core.service;

import com.assembleia.adm.core.domain.entity.Cooperado;
import com.assembleia.adm.core.port.inbound.CooperadoServicePort;

import java.util.List;
import java.util.Optional;

public class CooperadoService implements CooperadoServicePort {
    @Override
    public Cooperado criar(Cooperado cooperado) {
        return null;
    }

    @Override
    public Cooperado atualizar(Cooperado cooperado) {
        return null;
    }

    @Override
    public Optional<Cooperado> buscarPorId(Long idCooperado) {
        return Optional.empty();
    }

    @Override
    public Optional<Cooperado> buscarPorCpf(String cpf) {
        return Optional.empty();
    }

    @Override
    public List<Cooperado> lista() {
        return null;
    }
}
