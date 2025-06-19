package com.assembleia.adm.core.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "assembleia")
public class Assembleia {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "data_convocacao")
    private Date dataConvocacao;

    @Column(name = "data_assembleia")
    private Date dataAssembleia;

    @Column(name = "hora_assembleia")
    private String horaAssembleia;

    @Column
    private String local;

    @Column(name = "quorum_minimo")
    private Integer quorumMinimo;

    @Column
    private Integer quorum;

    @Column
    private String ata;

    @Column
    private String status;

    @OneToMany(mappedBy = "assembleia", fetch = FetchType.LAZY)
    private List<Pauta> pautas;

    @ManyToMany(mappedBy = "assembleias", fetch = FetchType.LAZY)
    private List<Cooperado> cooperados;

}
