package com.assembleia.adm.core.domain.entity;

import com.assembleia.adm.core.domain.enumeration.AssembleiaStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
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
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "assembleia")
public class Assembleia {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "assembleia_seq")
    @SequenceGenerator(name = "assembleia_seq", sequenceName = "assembleia_seq", allocationSize = 1)
    private Long id;

    @Column(name = "data_convocacao")
    private LocalDate dataConvocacao;

    @Column(name = "data_assembleia")
    private LocalDate dataAssembleia;

    @Column(name = "hora_assembleia")
    private LocalTime horaAssembleia;

    @Column
    private String local;

    @Column(name = "quorum_minimo")
    private Integer quorumMinimo;

    @Column(name = "tempo_sessao")
    private Integer tempoSessao;

    @Enumerated(EnumType.STRING)
    private AssembleiaStatus assembleiaStatus;

    @JsonBackReference
    @OneToMany(mappedBy = "assembleia", fetch = FetchType.LAZY)
    private List<Pauta> pautas;

    @JsonBackReference
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "assembleia_cooperado",
    joinColumns =  @JoinColumn(name = "idAssembleia"),
    inverseJoinColumns = @JoinColumn(name = "idCooperado"))
    private List<Cooperado> cooperados;

    public Assembleia(Long id){
        this.id = id;
    }

}
