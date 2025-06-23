package com.assembleia.adm.shared.dto;

import com.assembleia.adm.core.domain.enumeration.VotoStatus;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VotoDTO {

    @NotNull
    private VotoStatus votoStatus;

    @NotNull
    private Long idCooperado;

    @NotNull
    private Long idSessaoVotacao;

}
