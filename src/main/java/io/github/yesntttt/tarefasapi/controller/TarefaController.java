package io.github.yesntttt.tarefasapi.controller;

import io.github.yesntttt.tarefasapi.dto.TarefaDTORequest;
import io.github.yesntttt.tarefasapi.dto.TarefaDTOResponse;
import io.github.yesntttt.tarefasapi.dto.TarefaNovaCadastradaDTO;
import io.github.yesntttt.tarefasapi.service.TarefaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/tarefas")
@RequiredArgsConstructor
public class TarefaController {

    private final TarefaService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<TarefaNovaCadastradaDTO> salvar(@RequestBody @Valid  TarefaDTORequest dto) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.salvarTarefa(dto));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<TarefaDTOResponse> atualizarTarefa(@RequestBody @Valid TarefaDTORequest dto,
                                                             @PathVariable @Valid UUID id) {

        return ResponseEntity.ok(service.atualizarTarefa(dto, id));
    }
}
