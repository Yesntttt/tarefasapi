package io.github.yesntttt.tarefasapi.controller;

import io.github.yesntttt.tarefasapi.dto.UsuarioDTORequest;
import io.github.yesntttt.tarefasapi.dto.UsuarioDTOResponse;
import io.github.yesntttt.tarefasapi.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UsuarioDTOResponse> salvar(@RequestBody @Valid UsuarioDTORequest request) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.salvar(request));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public ResponseEntity<UsuarioDTOResponse> buscarPorId(@PathVariable @Valid UUID id) {

        return ResponseEntity.status(HttpStatus.FOUND)
                .body(service.buscarPorId(id));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.FOUND)
    public ResponseEntity<List<UsuarioDTOResponse>> buscarTodosUsuarios() {

        return ResponseEntity.status(HttpStatus.FOUND)
                .body(service.buscarTodosUsuarios());
    }
}
