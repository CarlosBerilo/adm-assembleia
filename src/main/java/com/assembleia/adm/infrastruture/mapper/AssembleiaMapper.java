package com.assembleia.adm.infrastruture.mapper;

import com.assembleia.adm.core.domain.entity.Assembleia;
import com.assembleia.adm.shared.dto.AssembleiaDTO;
import com.assembleia.adm.shared.dto.AssembleiaResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AssembleiaMapper {

    AssembleiaDTO toAssembleiaDTO(Assembleia assembleia);

    Assembleia toAssembleia(AssembleiaDTO assembleiaDTO);

    AssembleiaResponseDTO toAssembleiaResponseDTO(Assembleia assembleia);

}
