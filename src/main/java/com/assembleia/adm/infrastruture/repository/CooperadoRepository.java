package com.assembleia.adm.infrastruture.repository;

import com.assembleia.adm.core.domain.entity.Cooperado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CooperadoRepository extends JpaRepository<Cooperado, Long> {
    Cooperado findByCpf(String cpf);
}
