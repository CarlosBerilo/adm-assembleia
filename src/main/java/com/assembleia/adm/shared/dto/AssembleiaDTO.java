package com.assembleia.adm.shared.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssembleiaDTO {

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dataConvocacao;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dataAssembleia;

    private String horaAssembleia;

    private String local;

    private Integer quorumMinimo;

    private Integer tempoSessao;

}
