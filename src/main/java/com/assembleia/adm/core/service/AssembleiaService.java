package com.assembleia.adm.core.service;

import com.assembleia.adm.core.domain.entity.Assembleia;
import com.assembleia.adm.core.domain.enumeration.AssembleiaStatus;
import com.assembleia.adm.core.port.inbound.AssembleiaServicePort;
import com.assembleia.adm.core.port.outbound.AssembleiaDataPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssembleiaService implements AssembleiaServicePort {

    @Autowired
    private AssembleiaDataPort assembleiaDataPort;

    @Override
    public Assembleia criar(Assembleia assembleia) {
        assembleia.setAssembleiaStatus(AssembleiaStatus.MARCADA);
        return assembleiaDataPort.criar(assembleia);
    }

    @Override
    public Assembleia atualizar(Assembleia assembleia) {
        return assembleiaDataPort.atualizar(assembleia);
    }

    @Override
    public Optional<Assembleia> buscarPorId(Long idAssembleia) {
        return assembleiaDataPort.buscarPorId(idAssembleia);
    }

    @Override
    public List<Assembleia> lista() {
        return assembleiaDataPort.lista();
    }

    @Override
    public List<Assembleia> lista(AssembleiaStatus assembleiaStatus) {
        return assembleiaDataPort.lista(assembleiaStatus);
    }

    @Override
    public Assembleia incluirAta(Long idAssembleia,String ata) {
        return null;
    }
}
