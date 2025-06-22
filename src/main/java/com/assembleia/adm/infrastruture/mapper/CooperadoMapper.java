package com.assembleia.adm.infrastruture.mapper;

import com.assembleia.adm.core.domain.entity.Cooperado;
import com.assembleia.adm.shared.dto.CooperadoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CooperadoMapper {

    CooperadoDTO toCooperadoDTO(Cooperado cooperado);

    Cooperado toCooperado(CooperadoDTO cooperadoDTO);
}
