package io.github.yesntttt.tarefasapi.dto;

import java.util.UUID;

public record UsuarioNovoCadastradoDTO(UUID id,
                                       String nome,
                                       String email) {
}
