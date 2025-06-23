package com.assembleia.adm.entrypoint;

import com.assembleia.adm.core.domain.entity.SessaoVotacao;
import com.assembleia.adm.core.port.inbound.SessaoVotacaoServicePort;
import com.assembleia.adm.infrastruture.mapper.SessaoVotacaoMapper;
import com.assembleia.adm.shared.dto.SessaoVotacaoRequestDTO;
import com.assembleia.adm.shared.dto.SessaoVotacaoResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/sessaoVotacao")
public class SessaoVotacaoController {

    @Autowired
    private SessaoVotacaoServicePort sessaoVotacaoServicePort;

    @Autowired
    private SessaoVotacaoMapper sessaoVotacaoMapper;

    @PostMapping("/iniciar")
    public ResponseEntity<SessaoVotacaoResponseDTO> iniciarSessaoVotacao(SessaoVotacaoRequestDTO sessaoVotacaoRequestDTO) {
        //TODO: Validar se ja existe/inicializada "Sessão já inicializada"
        //TODO: Validar se ja existe/finalizada "Sessão já finalizada"
        SessaoVotacao sessaoVotacaoIniciada = sessaoVotacaoServicePort.iniciarSessaoVotacao(sessaoVotacaoRequestDTO.getTempoDeSessao(), sessaoVotacaoRequestDTO.getIdPauta());
        return new ResponseEntity<>(sessaoVotacaoMapper.toSessaoVotacaoResponseDTO(sessaoVotacaoIniciada), HttpStatus.CREATED);
    }

    @PutMapping("/finalizar/{id}")
    public ResponseEntity<SessaoVotacaoResponseDTO> finalizarSessaoVotacao(@PathVariable(value = "id") Long idSessaoVotacao) {
        SessaoVotacao sessaoVotacaoFinalizada = sessaoVotacaoServicePort.finalizarSessaoVotacao(idSessaoVotacao);
        return new ResponseEntity<>(sessaoVotacaoMapper.toSessaoVotacaoResponseDTO(sessaoVotacaoFinalizada), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SessaoVotacaoResponseDTO> sessaoVotacaoById(@PathVariable(value = "id") Long idSessaoVotacao) {
        return new ResponseEntity<>(sessaoVotacaoMapper.toSessaoVotacaoResponseDTO(sessaoVotacaoServicePort.sessaoVotacaoById(idSessaoVotacao)), HttpStatus.OK);
    }
}
