package io.github.yesntttt.tarefasapi.repository;

import io.github.yesntttt.tarefasapi.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {

    Boolean existsByEmail(String email);
}
