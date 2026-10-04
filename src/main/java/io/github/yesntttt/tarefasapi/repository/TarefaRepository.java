package io.github.yesntttt.tarefasapi.repository;

import io.github.yesntttt.tarefasapi.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, UUID> {
}
