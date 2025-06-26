package com.assembleia.adm.entrypoint;

import com.assembleia.adm.core.domain.entity.Pauta;
import com.assembleia.adm.core.port.inbound.PautaServicePort;
import com.assembleia.adm.infrastruture.mapper.PautaMapper;
import com.assembleia.adm.shared.dto.PautaDTO;
import com.assembleia.adm.shared.dto.PautaResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pauta")
public class PautaController {

    @Autowired
    private PautaServicePort pautaServicePort;
    @Autowired
    private PautaMapper pautaMapper;

    @PostMapping
    public ResponseEntity<PautaResponseDTO> cadastrar(@RequestBody PautaDTO pautaDTO){
        return new ResponseEntity<>(pautaMapper.toPautaResponseDTO(pautaServicePort.criar(pautaMapper.toPauta(pautaDTO))), HttpStatus.CREATED);
    }
}
