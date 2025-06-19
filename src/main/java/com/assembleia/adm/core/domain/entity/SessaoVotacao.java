package com.assembleia.adm.core.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sessao_votacao")
public class SessaoVotacao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp inicio;

    @Column(name = "termino")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp termino;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPauta", referencedColumnName = "id")
    private Pauta pauta;

    @OneToMany
    @JoinColumn(name = "idSessaoVotacao", referencedColumnName = "id")
    private List<Voto> votos;

}
