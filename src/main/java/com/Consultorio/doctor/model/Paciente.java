package com.Consultorio.doctor.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "pacientes") // Nome da tabela no banco de dados
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) // Garantir que o nome não seja nulo
    private String nome;

    @Column(nullable = false, unique = true) // Garantir que o email seja único e não nulo
    private String email;

    private String telefone; // Telefone não obrigatório

    @Column(name = "data_nascimento", nullable = false) // Garantir que a data de nascimento não seja nula
    private LocalDate dataNascimento;


}
