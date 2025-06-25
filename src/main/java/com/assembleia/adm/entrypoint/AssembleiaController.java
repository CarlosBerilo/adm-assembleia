package com.assembleia.adm.entrypoint;

import com.assembleia.adm.core.port.inbound.AssembleiaServicePort;
import com.assembleia.adm.infrastruture.mapper.AssembleiaMapper;
import com.assembleia.adm.shared.dto.AssembleiaDTO;
import com.assembleia.adm.shared.dto.AssembleiaResponseDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/assembleia")
public class AssembleiaController {

    @Autowired
    private AssembleiaServicePort assembleiaServicePort;

    @Autowired
    private AssembleiaMapper assembleiaMapper;

    @PostMapping
    public ResponseEntity<AssembleiaResponseDTO> criar(@RequestBody @Valid AssembleiaDTO assembleiaDTO){
        return new ResponseEntity<>(assembleiaMapper.toAssembleiaResponseDTO(assembleiaServicePort.criar(assembleiaMapper.toAssembleia(assembleiaDTO))), HttpStatus.OK);
    }

}
