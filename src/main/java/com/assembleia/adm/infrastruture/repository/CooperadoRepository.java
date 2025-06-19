package com.assembleia.adm.infrastruture.repository;

import com.assembleia.adm.core.domain.entity.Cooperado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CooperadoRepository extends JpaRepository<Cooperado, Long> {
    Optional<Cooperado> findByCpf(String cpf);
}
