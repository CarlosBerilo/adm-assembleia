package com.assembleia.adm.core.service;

import com.assembleia.adm.core.domain.entity.Cooperado;
import com.assembleia.adm.core.port.inbound.CooperadoServicePort;
import com.assembleia.adm.core.port.outbound.CooperadoDataPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CooperadoService implements CooperadoServicePort {

    @Autowired
    private CooperadoDataPort cooperadoDataPort;

    @Override
    public Cooperado criar(Cooperado cooperado) {
        return cooperadoDataPort.criar(cooperado);
    }

    @Override
    public Cooperado atualizar(Cooperado cooperado) {
        return cooperadoDataPort.atualizar(cooperado);
    }

    @Override
    public Optional<Cooperado> buscarPorId(Long idCooperado) {
        return cooperadoDataPort.buscarPorId(idCooperado);
    }

    @Override
    public Optional<Cooperado> buscarPorCpf(String cpf) {
        return cooperadoDataPort.buscarPorCpf(cpf);
    }

    @Override
    public List<Cooperado> lista() {
        return cooperadoDataPort.lista();
    }
}
