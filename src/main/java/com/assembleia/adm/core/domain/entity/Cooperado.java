package com.assembleia.adm.core.domain.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
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
@Table(name = "cooperado")
public class Cooperado {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cooperado_seq")
    @SequenceGenerator(name = "cooperado_seq", sequenceName = "cooperado_seq", allocationSize = 1)
    private Long id;

    @Column
    private String cpf;

    @Column
    private String nome;

    @ManyToMany(mappedBy = "cooperados", fetch = FetchType.LAZY)
    private List<Assembleia> assembleias;

    @ManyToMany(mappedBy = "cooperados", fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private List<Voto> votos;

}
