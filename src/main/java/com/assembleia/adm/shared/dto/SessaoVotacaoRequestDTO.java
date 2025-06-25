package com.assembleia.adm.shared.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SessaoVotacaoRequestDTO {

    @NotNull
    private Long idPauta;

    @NotNull
    @Min(1)
    private Integer tempoDeSessao;

}
