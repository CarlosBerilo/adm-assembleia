package com.assembleia.adm.core.service;

import com.assembleia.adm.core.domain.entity.Cooperado;
import com.assembleia.adm.core.port.inbound.CooperadoServicePort;
import com.assembleia.adm.core.port.outbound.CooperadoDataPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CooperadoService implements CooperadoServicePort {

    @Autowired
    private CooperadoDataPort cooperadoDataPort;

    @Override
    public Cooperado criar(Cooperado cooperado) {
        return cooperadoDataPort.criar(cooperado).orElseThrow(() -> new RuntimeException("Cooperado não casdastrado"));
    }

    @Override
    public Cooperado atualizar(Cooperado cooperado, Long id) {
        cooperado.setId(id);
        return cooperadoDataPort.atualizar(cooperado).orElseThrow(() -> new RuntimeException("Cooperado não atualizado"));
    }

    @Override
    public Cooperado buscarPorId(Long idCooperado) {
        return cooperadoDataPort.buscarPorId(idCooperado).orElseThrow(() -> new NoSuchElementException("Cooperado não encontrado"));
    }

    @Override
    public Cooperado buscarPorCpf(String cpf) {
        return cooperadoDataPort.buscarPorCpf(cpf).orElseThrow(() -> new NoSuchElementException("Cooperado não encontrado"));
    }

    @Override
    public List<Cooperado> lista() {
        return cooperadoDataPort.lista();
    }
}
