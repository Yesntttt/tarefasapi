package io.github.yesntttt.tarefasapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record TarefaDTORequest(

        @NotBlank(message = "O título da tarefa não pode ser nulo.")
        String titulo,

        @NotBlank(message="A descrição da tarefa não pode ser nulo.")
        String descricao,

        Boolean concluida,

        @NotNull(message = "O id do usuário deve ser informado.")
        UUID usuarioId
    ) {
}
