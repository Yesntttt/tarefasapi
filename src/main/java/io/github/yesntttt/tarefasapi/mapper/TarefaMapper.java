package io.github.yesntttt.tarefasapi.mapper;

import io.github.yesntttt.tarefasapi.dto.TarefaDTORequest;
import io.github.yesntttt.tarefasapi.dto.TarefaDTOResponse;
import io.github.yesntttt.tarefasapi.dto.TarefaNovaCadastradaDTO;
import io.github.yesntttt.tarefasapi.model.Tarefa;
import io.github.yesntttt.tarefasapi.repository.UsuarioRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class TarefaMapper {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Mapping(target = "usuario", expression = "java( usuarioRepository.findById(request.usuarioId()).orElse(null) )")
    public abstract Tarefa requestToEntity(TarefaDTORequest request);

    public abstract TarefaDTOResponse entityToResponse(Tarefa tarefa);

    public abstract TarefaNovaCadastradaDTO entityToTarefaNovaCadastrada(Tarefa tarefa);

    public abstract void updateEntity(TarefaDTORequest request,
                                      @MappingTarget Tarefa tarefa);
}
