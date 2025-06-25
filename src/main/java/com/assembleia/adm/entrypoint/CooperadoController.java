package com.assembleia.adm.entrypoint;

import com.assembleia.adm.core.port.inbound.CooperadoServicePort;
import com.assembleia.adm.infrastruture.mapper.CooperadoMapper;
import com.assembleia.adm.shared.dto.CooperadoDTO;
import com.assembleia.adm.shared.dto.CooperadoResponseDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/cooperado")
public class CooperadoController {

    @Autowired
    private CooperadoServicePort cooperadoServicePort;

    @Autowired
    private CooperadoMapper cooperadoMapper;

    @PostMapping
    public ResponseEntity<CooperadoResponseDTO> cadastrar(@RequestBody @Valid CooperadoDTO cooperadoDTO){
            return new ResponseEntity<>(cooperadoMapper.toCooperadoResponseDTO(cooperadoServicePort.criar(cooperadoMapper.toCooperado(cooperadoDTO))), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CooperadoResponseDTO> atualizar(@RequestBody @Valid CooperadoDTO cooperadoDTO, @PathVariable("id") Long id){
        return new ResponseEntity<>(cooperadoMapper.toCooperadoResponseDTO(cooperadoServicePort.atualizar(cooperadoMapper.toCooperado(cooperadoDTO), id)), HttpStatus.OK);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<CooperadoResponseDTO> buscarPorCpf(@PathVariable("cpf") String cpf){
        return new ResponseEntity<>(cooperadoMapper.toCooperadoResponseDTO(cooperadoServicePort.buscarPorCpf(cpf)), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CooperadoResponseDTO>> lista(){
        return new ResponseEntity<>(cooperadoMapper.toListCooperado(cooperadoServicePort.lista()), HttpStatus.OK);
    }

}
