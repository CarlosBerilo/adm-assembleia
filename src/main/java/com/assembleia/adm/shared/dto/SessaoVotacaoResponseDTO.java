package com.assembleia.adm.shared.dto;

import com.assembleia.adm.core.domain.entity.Pauta;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SessaoVotacaoResponseDTO {

    private Pauta pauta;

}
