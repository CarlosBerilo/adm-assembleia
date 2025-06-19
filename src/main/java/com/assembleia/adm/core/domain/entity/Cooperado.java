package com.assembleia.adm.core.domain.entity;

import com.assembleia.adm.core.domain.entity.Assembleia;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cooperado")
public class Cooperado {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private String cpf;

    @Column
    private String nome;

    @ManyToMany(mappedBy = "cooperados", fetch = FetchType.LAZY)
    private List<Assembleia> assembleias;

}
