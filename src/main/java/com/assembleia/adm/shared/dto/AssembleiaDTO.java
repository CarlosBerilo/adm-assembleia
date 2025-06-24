package com.assembleia.adm.shared.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssembleiaDTO {

    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dataConvocacao;

    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dataAssembleia;

    @NotEmpty
    private String horaAssembleia;

    @NotEmpty
    private String local;

    @NotNull
    private Integer quorumMinimo;

    @NotNull
    private Integer tempoSessao;

}
