package com.assembleia.adm.core.service;

import com.assembleia.adm.core.domain.entity.Assembleia;
import com.assembleia.adm.core.domain.entity.Pauta;
import com.assembleia.adm.core.port.inbound.PautaServicePort;
import com.assembleia.adm.core.port.outbound.AssembleiaDataPort;
import com.assembleia.adm.core.port.outbound.PautaDataPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PautaService implements PautaServicePort {

    @Autowired
    private PautaDataPort pautaDataPort;
    @Autowired
    private AssembleiaDataPort assembleiaDataPort;
    @Override
    public Pauta criar(Pauta pauta) {
        Pauta pautaCriada = pautaDataPort.criar(pauta).orElseThrow(() -> new RuntimeException("Error ao tentar criar Pauta"));
        Assembleia assembleia = assembleiaDataPort.buscarPorId(pautaCriada.getAssembleia().getId()).orElseThrow(() -> new RuntimeException("Assembleia não encontrada"));
        pautaCriada.setAssembleia(assembleia);
        return pautaCriada;
    }

    @Override
    public Pauta atualizar(Pauta pauta) {
        return pautaDataPort.atualizar(pauta).orElseThrow(() -> new RuntimeException("Error ao tentar atualizar Pauta"));
    }

    @Override
    public Pauta buscarPorId(Long idPauta) {
        return pautaDataPort.buscarPorId(idPauta).orElseThrow(() -> new RuntimeException("Pauta não encontrada"));
    }

    @Override
    public List<Pauta> listaPorAssembleia(Long idAssembleia) {
        return pautaDataPort.listaPorAssembleia(idAssembleia);
    }
}
