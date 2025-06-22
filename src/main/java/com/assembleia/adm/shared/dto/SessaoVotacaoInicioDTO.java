package com.assembleia.adm.shared.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SessaoVotacaoInicioDTO {

    private Long idPauta;

    private Integer tempo;

}
