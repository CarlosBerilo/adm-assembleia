package com.assembleia.adm.infrastruture.adapter;

import com.assembleia.adm.core.domain.entity.Cooperado;
import com.assembleia.adm.core.port.outbound.CooperadoDataPort;
import com.assembleia.adm.infrastruture.config.Adapter;
import com.assembleia.adm.infrastruture.repository.CooperadoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Adapter
public class CooperadoAdapter implements CooperadoDataPort {

    @Autowired
    private CooperadoRepository cooperadoRepository;

    @Override
    public Optional<Cooperado> criar(Cooperado cooperado) {
        return Optional.of(cooperadoRepository.save(cooperado));
    }

    @Override
    public Optional<Cooperado> atualizar(Cooperado cooperado) {
        return Optional.of(cooperadoRepository.save(cooperado));
    }

    @Override
    public Optional<Cooperado> buscarPorId(Long idCooperado) {
        return cooperadoRepository.findById(idCooperado);
    }

    @Override
    public Optional<Cooperado> buscarPorCpf(String cpf) {
        return Optional.of(cooperadoRepository.findByCpf(cpf));
    }

    @Override
    public List<Cooperado> lista() {
        return cooperadoRepository.findAll();
    }
}
