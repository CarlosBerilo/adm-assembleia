package com.assembleia.adm.core.service;

import com.assembleia.adm.core.domain.entity.Assembleia;
import com.assembleia.adm.core.domain.entity.Pauta;
import com.assembleia.adm.core.port.inbound.PautaServicePort;
import com.assembleia.adm.core.port.outbound.AssembleiaDataPort;
import com.assembleia.adm.core.port.outbound.PautaDataPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PautaService implements PautaServicePort {

    @Autowired
    private PautaDataPort pautaDataPort;
    @Autowired
    private AssembleiaDataPort assembleiaDataPort;
    @Override
    public Pauta criar(Pauta pauta) {
        Pauta pautaCriada = pautaDataPort.criar(pauta);
        Optional<Assembleia> assembleia = assembleiaDataPort.buscarPorId(pautaCriada.getAssembleia().getId());
        pautaCriada.setAssembleia(assembleia.get());
        return pautaCriada;
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
