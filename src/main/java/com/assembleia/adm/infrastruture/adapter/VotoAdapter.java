package com.assembleia.adm.infrastruture.adapter;

import com.assembleia.adm.core.domain.entity.Voto;
import com.assembleia.adm.core.port.outbound.VotoDataPort;
import com.assembleia.adm.infrastruture.config.Adapter;
import com.assembleia.adm.infrastruture.repository.VotoRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Adapter
public class VotoAdapter implements VotoDataPort {

    @Autowired
    private VotoRepository votoRepository;

    @Override
    public Voto votar(Voto voto) {
        return votoRepository.save(voto);
    }
}
