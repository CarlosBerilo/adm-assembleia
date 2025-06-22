package com.assembleia.adm.shared.dto;

import com.assembleia.adm.core.domain.entity.Pauta;
import com.assembleia.adm.core.domain.enumeration.SessaoVotacaoStatus;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.sql.Timestamp;

@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SessaoVotacaoResponseDTO {

    private Long id;

    private Timestamp inicio;

    private Timestamp termino;

    private SessaoVotacaoStatus sessaoVotacaoStatus;

    private Integer totalVotos;

    private Integer totalVotosSim;

    private Integer totalVotosNao;

    private Pauta pauta;
}
