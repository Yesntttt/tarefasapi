package io.github.yesntttt.tarefasapi.dto;

import java.time.LocalDate;
import java.util.UUID;

public record TarefaNovaCadastradaDTO(
        UUID id,
        String tituloString,
        String descricao,
        LocalDate dataCriacao,
        Boolean concluida
) {
}
