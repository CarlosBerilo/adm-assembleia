package com.assembleia.adm.core.port.outbound;

import com.assembleia.adm.core.domain.entity.Cooperado;
import java.util.List;
import java.util.Optional;

public interface CooperadoDataPort {

    Cooperado criar(Cooperado cooperado);

    Cooperado atualizar(Cooperado cooperado);

    Optional<Cooperado> buscarPorId(Long idCooperado);

    Optional<Cooperado> buscarPorCpf(String cpf);

    List<Cooperado> lista();
}
