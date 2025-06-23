package com.assembleia.adm.shared.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PautaResponseDTO {

    private Long id;

    private String descricao;

    private AssembleiaResponseDTO assembleiaResponseDTO;

}
