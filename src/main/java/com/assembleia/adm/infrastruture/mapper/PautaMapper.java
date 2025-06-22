package com.assembleia.adm.infrastruture.mapper;

import com.assembleia.adm.core.domain.entity.Assembleia;
import com.assembleia.adm.core.domain.entity.Pauta;
import com.assembleia.adm.shared.dto.AssembleiaDTO;
import com.assembleia.adm.shared.dto.AssembleiaResponseDTO;
import com.assembleia.adm.shared.dto.PautaDTO;
import com.assembleia.adm.shared.dto.PautaResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PautaMapper {

    default Pauta toPauta(PautaDTO pautaDTO){
        return new Pauta(pautaDTO.getDescricao(), new Assembleia(pautaDTO.getIdAssembleia()));
    }

    default PautaResponseDTO toPautaResponseDTO(Pauta pauta){
        return new PautaResponseDTO(pauta.getId(),
                pauta.getDescricao(),
                AssembleiaResponseDTO.builder()
                        .id(pauta.getAssembleia().getId())
                        .dataConvocacao(pauta.getAssembleia().getDataConvocacao())
                        .dataAssembleia(pauta.getAssembleia().getDataAssembleia())
                        .horaAssembleia(pauta.getAssembleia().getHoraAssembleia())
                        .local(pauta.getAssembleia().getLocal())
                        .quorumMinimo(pauta.getAssembleia().getQuorumMinimo())
                        .tempoSessao(pauta.getAssembleia().getTempoSessao())
                        .build()
        );
    }
}
