package com.assembleia.adm.core.domain.entity;

import com.assembleia.adm.core.domain.enumeration.SessaoVotacaoStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.sql.Timestamp;
import java.util.List;

@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sessao_votacao")
public class SessaoVotacao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sessao_votacao_seq")
    @SequenceGenerator(name = "sessao_votacao_seq", sequenceName = "sessao_votacao_seq", allocationSize = 1)
    private Long id;

    @Column(name = "inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp inicio;

    @Column(name = "previsao_termino")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp previsaoTermino;

    @Column(name = "termino")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp termino;

    @Enumerated(EnumType.STRING)
    private SessaoVotacaoStatus sessaoVotacaoStatus;

    @Column
    private Integer totalVotos;

    @Column
    private Integer totalVotosSim;

    @Column
    private Integer totalVotosNao;

    @JsonBackReference
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idPauta", referencedColumnName = "id")
    private Pauta pauta;

    @ManyToMany(mappedBy = "sessaoVotacao",fetch = FetchType.LAZY)
    private List<Voto> votos;

}
