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
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
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
    private LocalDateTime inicio;

    @Column(name = "previsao_termino")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime previsaoTermino;

    @Column(name = "termino")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime termino;

    @Enumerated(EnumType.STRING)
    private SessaoVotacaoStatus sessaoVotacaoStatus;

    @Column
    private Integer totalVotos = 0;

    @Column
    private Integer totalVotosSim = 0;

    @Column
    private Integer totalVotosNao = 0;

    @JsonBackReference
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idPauta", referencedColumnName = "id")
    private Pauta pauta;

    @JsonManagedReference
    @ManyToMany(mappedBy = "sessaoVotacao",fetch = FetchType.EAGER)
    private List<Voto> votos;

}
