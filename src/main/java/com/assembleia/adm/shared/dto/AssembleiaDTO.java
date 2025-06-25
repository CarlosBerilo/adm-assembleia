package com.assembleia.adm.shared.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssembleiaDTO {

    @NotNull
    private LocalDate dataConvocacao;

    @NotNull
    private LocalDate dataAssembleia;

    @NotNull
    @DateTimeFormat(pattern = "hh:mm", iso = DateTimeFormat.ISO.TIME)
    private LocalTime horaAssembleia;

    @NotEmpty
    private String local;

    @NotNull
    @Min(1)
    private Integer quorumMinimo;

    @NotNull
    @Min(1)
    private Integer tempoSessao;

}
