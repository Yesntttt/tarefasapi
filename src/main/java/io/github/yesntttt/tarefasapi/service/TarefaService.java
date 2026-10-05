package io.github.yesntttt.tarefasapi.service;

import io.github.yesntttt.tarefasapi.dto.TarefaDTORequest;
import io.github.yesntttt.tarefasapi.dto.TarefaDTOResponse;
import io.github.yesntttt.tarefasapi.dto.TarefaNovaCadastradaDTO;
import io.github.yesntttt.tarefasapi.exceptions.RegistroNaoEncontradoException;
import io.github.yesntttt.tarefasapi.mapper.TarefaMapper;
import io.github.yesntttt.tarefasapi.model.Tarefa;
import io.github.yesntttt.tarefasapi.repository.TarefaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TarefaService {

    private final TarefaRepository repository;
    private final TarefaMapper mapper;

    public TarefaNovaCadastradaDTO salvarTarefa(TarefaDTORequest dto) {
        Tarefa tarefa = mapper.requestToEntity(dto);

        tarefa.setDataCriacao(LocalDate.now());

        repository.save(tarefa);

        return mapper.entityToTarefaNovaCadastrada(tarefa);
    }

    public TarefaDTOResponse atualizarTarefa(TarefaDTORequest dto, UUID id) {
        Tarefa tarefa = repository.findById(id)
                .orElseThrow(() -> new RegistroNaoEncontradoException("Tarefa não encontrada."));

        mapper.updateEntity(dto, tarefa);
        repository.save(tarefa);

        return mapper.entityToResponse(tarefa);
    }
}
