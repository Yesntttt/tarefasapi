package io.github.yesntttt.tarefasapi.dto;

import java.util.UUID;

public record TarefaDTOResponse(
        UUID id,

        String tituloString,

        String descricao,

        Boolean concluida
)   {
}
