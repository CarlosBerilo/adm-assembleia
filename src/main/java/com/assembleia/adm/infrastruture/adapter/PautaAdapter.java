package com.assembleia.adm.infrastruture.adapter;

import com.assembleia.adm.core.domain.entity.Pauta;
import com.assembleia.adm.core.port.outbound.PautaDataPort;
import com.assembleia.adm.infrastruture.config.Adapter;
import com.assembleia.adm.infrastruture.repository.PautaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Adapter
public class PautaAdapter implements PautaDataPort {

    @Autowired
    private PautaRepository pautaRepository;

    @Override
    public Pauta criar(Pauta pauta) {
        return pautaRepository.save(pauta);
    }

    @Override
    public Pauta atualizar(Pauta pauta) {
        return pautaRepository.save(pauta);
    }

    @Override
    public Optional<Pauta> buscarPorId(Long idPauta) {
        return pautaRepository.findById(idPauta);
    }

    @Override
    public List<Pauta> listaPorAssembleia(Long idAssembleia) {
        return pautaRepository.findAll();
    }
}
