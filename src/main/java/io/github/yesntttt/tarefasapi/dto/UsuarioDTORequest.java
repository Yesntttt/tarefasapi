package io.github.yesntttt.tarefasapi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UsuarioDTORequest(

        @NotBlank(message = "O nome de usuário deve ser informado.")
        String nome,

        @NotBlank(message = "O email de usuário deve ser informado.")
        @Email
        String email,

        @NotBlank(message = "O usuário deve possuir uma senha.")
        String senha
)   {
}
