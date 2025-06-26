package com.assembleia.adm.core.port.inbound;

import com.assembleia.adm.core.domain.entity.Cooperado;

import java.util.List;
import java.util.Optional;

public interface CooperadoServicePort {
    Cooperado salvar(Cooperado cooperado);

    Cooperado atualizar(Cooperado cooperado, Long id);

    Cooperado buscarPorId(Long idCooperado);

    Cooperado buscarPorCpf(String cpf);

    List<Cooperado> lista();
}
