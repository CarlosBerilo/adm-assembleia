package com.assembleia.adm.core.domain.entity;

import com.assembleia.adm.core.domain.enumeration.VotoStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "voto")
public class Voto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "voto_seq")
    @SequenceGenerator(name = "voto_seq", sequenceName = "voto_seq", allocationSize = 1)
    private Long id;

    @Enumerated(EnumType.STRING)
    private VotoStatus votoStatus;

    @JsonBackReference
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(name = "voto_cooperado",
            joinColumns =  @JoinColumn(name = "id_voto"),
            inverseJoinColumns = @JoinColumn(name = "id_cooperado"))
    private List<Cooperado> cooperados;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sessao_votacao", nullable = false)
    private SessaoVotacao sessaoVotacao;

}
