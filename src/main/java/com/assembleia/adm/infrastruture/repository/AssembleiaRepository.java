package com.assembleia.adm.infrastruture.repository;

import com.assembleia.adm.core.domain.entity.Assembleia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssembleiaRepository extends JpaRepository<Assembleia, Long> {
    List<Assembleia> findByStatus(String status);
}
