package io.github.yesntttt.tarefasapi.service;

import io.github.yesntttt.tarefasapi.model.Tarefa;
import io.github.yesntttt.tarefasapi.repository.TarefaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TarefaService {

    private final TarefaRepository repository;

    public Tarefa salvar(Tarefa tarefa) {
        return repository.save(tarefa);
    }
}
