package io.github.yesntttt.tarefasapi.model;

import io.hypersistence.utils.hibernate.type.array.ListArrayType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "usuario")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @NotBlank(message = "O nome de usuário deve ser informado.")
    @Column(name = "nome", nullable = false, length = 50)
    private String nome;

    @NotBlank(message = "O email de usuário deve ser informado.")
    @Email
    @Column(name = "email", nullable = false, unique = true, length = 150)
    private String email;

    @NotBlank(message = "O usuário deve possuir uma senha.")
    @Column(name = "senha", nullable = false)
    private String senha;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    @Type(ListArrayType.class)
    @Column(name = "tarefas", columnDefinition = "varchar[]")
    private List<Tarefa> tarefas;
}
