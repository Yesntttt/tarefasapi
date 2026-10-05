package io.github.yesntttt.tarefasapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "tarefa")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @NotBlank(message = "O título da tarefa não pode ser nulo.")
    @Column(name = "titulo", nullable = false, length = 30)
    private String titulo;

    @NotBlank(message = "A descrição da tarefa não pode ser nulo.")
    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "data_criacao")
    private LocalDate dataCriacao;

    @Column(name = "data_finalizada")
    private LocalDate dataFinalizada;

    @Column(name = "concluida")
    private Boolean concluida = false;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;
}
