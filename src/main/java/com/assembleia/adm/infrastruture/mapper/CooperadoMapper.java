package com.assembleia.adm.infrastruture.mapper;

import com.assembleia.adm.core.domain.entity.Cooperado;
import com.assembleia.adm.shared.dto.CooperadoDTO;
import com.assembleia.adm.shared.dto.CooperadoResponseDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CooperadoMapper {

    CooperadoDTO toCooperadoDTO(Cooperado cooperado);

    Cooperado toCooperado(CooperadoDTO cooperadoDTO);

    CooperadoResponseDTO toCooperadoResponseDTO(Cooperado cooperado);

    List<CooperadoResponseDTO> toListCooperado(List<Cooperado> cooperado);

}
