package com.assembleia.adm.entrypoint;

import com.assembleia.adm.core.port.inbound.VotoServicePort;
import com.assembleia.adm.infrastruture.mapper.VotoMapper;
import com.assembleia.adm.shared.dto.VotoDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/voto")
public class VotoController {

    @Autowired
    private VotoServicePort votoServicePort;

    @Autowired
    private VotoMapper votoMapper;

    @PostMapping
    public ResponseEntity<String> salvar(@RequestBody @Valid VotoDTO votoDTO){
        votoServicePort.votar(votoMapper.toVoto(votoDTO));
        return new ResponseEntity<>("Voto realizado com sucesso", HttpStatus.OK);
    }
}
