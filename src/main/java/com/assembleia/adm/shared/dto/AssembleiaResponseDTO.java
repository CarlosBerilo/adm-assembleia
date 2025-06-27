package com.assembleia.adm.shared.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssembleiaResponseDTO {

    private Long id;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataConvocacao;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataAssembleia;

    private String horaAssembleia;

    private String local;

    private Integer quorumMinimo;

    private Integer tempoSessao;
}
