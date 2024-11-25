package com.Consultorio.doctor.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "consultas") // Especifica o nome da tabela no banco de dados
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false) // Define a chave estrangeira para a tabela pacientes
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "medico_id", nullable = false) // Define a chave estrangeira para a tabela medicos
    private Medico medico;

    @Column(nullable = false)
    private LocalDate data;

    @Column(name = "hora_consulta", nullable = false) // Ajuste para corresponder ao nome no banco
    private LocalTime hora;


    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }
}
