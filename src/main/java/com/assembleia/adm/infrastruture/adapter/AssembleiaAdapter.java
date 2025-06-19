package com.assembleia.adm.infrastruture.adapter;

import com.assembleia.adm.core.domain.entity.Assembleia;
import com.assembleia.adm.core.port.outbound.AssembleiaDataPort;
import com.assembleia.adm.infrastruture.config.Adapter;
import com.assembleia.adm.infrastruture.repository.AssembleiaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Adapter
public class AssembleiaAdapter implements AssembleiaDataPort {

    @Autowired
    private AssembleiaRepository assembleiaRepository;

    @Override
    public Assembleia criar(Assembleia assembleia) {
        return assembleiaRepository.save(assembleia);
    }

    @Override
    public Assembleia atualizar(Assembleia assembleia) {
        return assembleiaRepository.save(assembleia);
    }

    @Override
    public Optional<Assembleia> buscarPorId(Long idAssembleia) {
        return assembleiaRepository.findById(idAssembleia);
    }

    @Override
    public List<Assembleia> lista() {
        return assembleiaRepository.findAll();
    }

    @Override
    public List<Assembleia> lista(String status) {
        return null;
    }
}
