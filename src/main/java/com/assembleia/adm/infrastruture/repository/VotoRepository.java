package com.assembleia.adm.infrastruture.repository;

import com.assembleia.adm.core.domain.entity.SessaoVotacao;
import com.assembleia.adm.core.domain.entity.Voto;
import com.assembleia.adm.core.domain.enumeration.VotoStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VotoRepository extends JpaRepository<Voto, Long> {
    List<Voto> findBySessaoVotacao(SessaoVotacao sessaoVotacao);

    List<Voto> findBySessaoVotacaoAndVotoStatus(SessaoVotacao sessaoVotacao, VotoStatus votoStatus);

}
