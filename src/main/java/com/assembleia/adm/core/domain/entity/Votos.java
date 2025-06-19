package com.assembleia.adm.core.domain.entity;

import com.assembleia.adm.core.domain.enumeration.Voto;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "votacao")
public class Votos {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pauta", referencedColumnName = "id")
    private Pauta pauta;

    @OneToOne
    @JoinColumn(name = "id_cooperado", referencedColumnName = "id")
    private Cooperado cooperado;

    @Enumerated(EnumType.STRING)
    private Voto voto;


}
