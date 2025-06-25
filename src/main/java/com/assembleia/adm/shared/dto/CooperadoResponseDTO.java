package com.assembleia.adm.shared.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CooperadoResponseDTO {

    private Long id;

    private String cpf;

    private String nome;

}