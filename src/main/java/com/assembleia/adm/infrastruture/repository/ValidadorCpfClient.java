package com.assembleia.adm.infrastruture.repository;

import com.assembleia.adm.core.domain.entity.Usuario;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "usuario",url = "${validador.cpf.client}")
public interface ValidadorCpfClient {

    @GetMapping("/{cpf}")
    Usuario usuarioCpf(@PathVariable(value = "cpf") String cpf);

}
