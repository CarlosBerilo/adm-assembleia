package com.assembleia.adm.entrypoint;

import com.assembleia.adm.core.domain.entity.Cooperado;
import com.assembleia.adm.core.port.inbound.CooperadoServicePort;
import com.assembleia.adm.infrastruture.mapper.CooperadoMapper;
import com.assembleia.adm.shared.dto.CooperadoDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/cooperado")
public class CooperadoController {

    @Autowired
    private CooperadoServicePort cooperadoServicePort;

    @Autowired
    private CooperadoMapper cooperadoMapper;

    @PostMapping
    public ResponseEntity<CooperadoDTO> cadastrar(@RequestBody @Valid CooperadoDTO cooperadoDTO){
            return new ResponseEntity<>(cooperadoMapper.toCooperadoDTO(cooperadoServicePort.criar(cooperadoMapper.toCooperado(cooperadoDTO))), HttpStatus.CREATED);
    }

}
