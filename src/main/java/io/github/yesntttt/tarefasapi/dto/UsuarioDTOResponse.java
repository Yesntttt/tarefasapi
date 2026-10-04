package io.github.yesntttt.tarefasapi.dto;

import io.github.yesntttt.tarefasapi.model.Tarefa;

import java.util.List;
import java.util.UUID;

public record UsuarioDTOResponse(
        UUID id,
        String nome,
        String email,
        List<Tarefa> tarefas
)   {
}
