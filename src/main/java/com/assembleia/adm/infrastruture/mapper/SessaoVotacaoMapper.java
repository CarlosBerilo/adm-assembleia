package com.assembleia.adm.infrastruture.mapper;

import com.assembleia.adm.core.domain.entity.SessaoVotacao;
import com.assembleia.adm.shared.dto.SessaoVotacaoResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SessaoVotacaoMapper {
    SessaoVotacaoResponseDTO toSessaoVotacaoResponseDTO(SessaoVotacao sessaoVotacao);

}
