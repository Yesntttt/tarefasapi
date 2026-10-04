package io.github.yesntttt.tarefasapi.controller.common;

import io.github.yesntttt.tarefasapi.dto.ErroResposta;
import io.github.yesntttt.tarefasapi.exceptions.OperacaoNaoPermitidaException;
import io.github.yesntttt.tarefasapi.exceptions.RegistroDuplicadoException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(OperacaoNaoPermitidaException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErroResposta handleOperacaoNaoPermitidaException(OperacaoNaoPermitidaException e) {
        return ErroResposta.respostaPadrao(e.getMessage());
    }

    @ExceptionHandler(RegistroDuplicadoException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErroResposta handleRegistroDuplicadoException(RegistroDuplicadoException e) {
        return ErroResposta.conflito(e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErroResposta handleTrataErrosGenericos() {
        return new ErroResposta(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Erro inesperado, entre em contato com os adminstradores.",
                List.of());
    }
}
