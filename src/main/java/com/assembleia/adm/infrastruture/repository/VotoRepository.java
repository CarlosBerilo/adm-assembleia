package com.assembleia.adm.infrastruture.repository;

import com.assembleia.adm.core.domain.entity.SessaoVotacao;
import com.assembleia.adm.core.domain.entity.Voto;
import com.assembleia.adm.core.domain.enumeration.VotoStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VotoRepository extends JpaRepository<Voto, Long> {
    List<Voto> findBySessaoVotacao(SessaoVotacao sessaoVotacao);

    List<Voto> findBySessaoVotacaoAndVotoStatus(SessaoVotacao sessaoVotacao, VotoStatus votoStatus);

    //@Query(value = "select v from voto v inner join voto_cooperado vc on v.id = vc.id_voto where vc.id_cooperado = :idCooperado and v.id_sessao_votacao = :idSessaoVotacao", nativeQuery = true)
    @Query(value = "select count(*) from voto v " +
            "inner join voto_cooperado vc on v.id = vc.id_voto " +
            "where vc.id_cooperado = :idCooperado and v.id_sessao_votacao = :idSessaoVotacao", nativeQuery = true)
    int findByCooperadoAndSessaoVotacao(@Param(value = "idCooperado") long idCooperado, @Param(value = "idSessaoVotacao") long idSessaoVotacao);

}
