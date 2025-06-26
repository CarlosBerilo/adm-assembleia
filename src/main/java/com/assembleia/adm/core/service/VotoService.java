package com.assembleia.adm.core.service;

import com.assembleia.adm.core.domain.entity.Cooperado;
import com.assembleia.adm.core.domain.entity.Voto;
import com.assembleia.adm.core.port.inbound.VotoServicePort;
import com.assembleia.adm.core.port.outbound.CooperadoDataPort;
import com.assembleia.adm.core.port.outbound.VotoDataPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VotoService implements VotoServicePort {

    @Autowired
    private VotoDataPort votoDataPort;

    @Autowired
    private CooperadoDataPort cooperadoDataPort;

    @Override
    public void votar(Voto voto) {
        if(votoDataPort.votoExiste(voto.getCooperados().getFirst().getId(), voto.getSessaoVotacao().getId()) > 0)
            throw new RuntimeException("Voto já realizado");

        try {
            Optional<Cooperado> cooperado = cooperadoDataPort.buscarPorId(voto.getCooperados().getFirst().getId());
            if(cooperado.isPresent()) {
                cooperadoDataPort.validarCpf(cooperado.get().getCpf());
                votoDataPort.votar(voto);
            }else
                throw new RuntimeException("Cooperado não encontrado");
        }catch (Exception ex){
               throw new RuntimeException("Voto não computado.Dados divergentes ou voto já computado");
        }
    }

    @Override
    public Integer totalVotos(Long idSessaoVotacao) {
        return votoDataPort.totalVotos(idSessaoVotacao);
    }

    @Override
    public Integer totalVotosSim(Long idSessaoVotacao) {
        return votoDataPort.totalVotosSim(idSessaoVotacao);
    }

    @Override
    public Integer totalVotosNao(Long idSessaoVotacao) {
        return votoDataPort.totalVotosNao(idSessaoVotacao);
    }
}
