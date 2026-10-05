package io.github.yesntttt.tarefasapi.service;

import io.github.yesntttt.tarefasapi.dto.*;
import io.github.yesntttt.tarefasapi.exceptions.RegistroDuplicadoException;
import io.github.yesntttt.tarefasapi.mapper.UsuarioMapper;
import io.github.yesntttt.tarefasapi.model.Tarefa;
import io.github.yesntttt.tarefasapi.model.Usuario;
import io.github.yesntttt.tarefasapi.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repository;
    private final UsuarioMapper mapper;

    public UsuarioNovoCadastradoDTO salvar(UsuarioDTORequest request) {
        boolean usuarioEncontrado = repository.existsByEmail(request.email());

        if(usuarioEncontrado) {
            throw new RegistroDuplicadoException("Usuário ja cadastrado.");
        }

        Usuario usuario = mapper.requestToEntity(request);

        repository.save(usuario);

        return mapper.entityToUsuarioNovoCadastrado(usuario);
    }

    public UsuarioDTOResponse buscarPorId(UUID id) {
        Usuario usuarioEncontrado = repository.findById(id).orElseThrow(
                () -> new RuntimeException("Usuário não encontrado"));

        return mapper.entityToResponse(usuarioEncontrado);
    }

    public List<UsuarioDTOResponse> buscarTodosUsuarios() {

        List<Usuario> usuarios = repository.findAll();

        return usuarios.stream()
                .map(mapper::entityToResponse)
                .collect(Collectors.toList());
    }
}
