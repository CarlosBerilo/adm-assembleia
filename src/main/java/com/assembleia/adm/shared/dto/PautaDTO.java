package com.assembleia.adm.shared.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PautaDTO {

    @NotEmpty
    private String descricao;

    @NotEmpty
    private Long idAssembleia;
}
