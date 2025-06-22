package com.assembleia.adm.infrastruture.mapper;

import com.assembleia.adm.core.domain.entity.Cooperado;
import com.assembleia.adm.core.domain.entity.SessaoVotacao;
import com.assembleia.adm.core.domain.entity.Voto;
import com.assembleia.adm.shared.dto.VotoDTO;
import org.mapstruct.Mapper;

import java.util.Arrays;

@Mapper(componentModel = "spring")
public interface VotoMapper {
    default Voto toVoto(VotoDTO votoDTO){
        return Voto.builder()
                .votoStatus(votoDTO.getVotoStatus())
                .cooperados(Arrays.asList(Cooperado.builder().id(votoDTO.getIdCooperado()).build()))
                .sessaoVotacao(SessaoVotacao.builder().id(votoDTO.getIdSessaoVotacao()).build())
                .build();
    }
}
