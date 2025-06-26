package com.assembleia.adm.core.service;

import com.assembleia.adm.core.domain.entity.Assembleia;
import com.assembleia.adm.core.domain.entity.Pauta;
import com.assembleia.adm.core.port.inbound.AssembleiaServicePort;
import com.assembleia.adm.core.port.inbound.PautaServicePort;
import com.assembleia.adm.core.port.outbound.PautaDataPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PautaService implements PautaServicePort {

    @Autowired
    private PautaDataPort pautaDataPort;
    @Autowired
    private AssembleiaServicePort assembleiaServicePort;
    @Override
    public Pauta criar(Pauta pauta) {
        var assembleia = assembleiaServicePort.buscarPorId(pauta.getAssembleia().getId());
        var pautaCriada = pautaDataPort.criar(pauta).orElseThrow(() -> new RuntimeException("Error ao tentar salvar Pauta"));
        pautaCriada.setAssembleia(assembleia);
        return pautaCriada;
    }

    @Override
    public Pauta atualizar(Pauta pauta) {
        return pautaDataPort.atualizar(pauta).orElseThrow(() -> new RuntimeException("Error ao tentar atualizar Pauta"));
    }

    @Override
    public Pauta buscarPorId(Long idPauta) {
        return pautaDataPort.buscarPorId(idPauta).orElseThrow(() -> new NoSuchElementException("Pauta não encontrada"));
    }

    @Override
    public List<Pauta> listaPorAssembleia(Long idAssembleia) {
        return pautaDataPort.listaPorAssembleia(idAssembleia);
    }
}
