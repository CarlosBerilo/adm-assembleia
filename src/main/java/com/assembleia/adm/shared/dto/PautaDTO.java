package com.assembleia.adm.shared.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PautaDTO {

    private String descricao;

    private Long idAssembleia;
}
