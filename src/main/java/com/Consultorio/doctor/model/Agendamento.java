package com.Consultorio.doctor.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "agendamentos") // Nome da tabela no banco de dados
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false) // Relacionamento com Paciente
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "medico_id", nullable = false) // Relacionamento com Médico
    private Medico medico;

    @Column(name = "data_hora", nullable = false) // Coluna para data e hora do agendamento
    private LocalDateTime dataHora;

    // Construtor sem parâmetros (necessário para a JPA)
    public Agendamento() {
    }

    // Construtor com parâmetros
    public Agendamento(Paciente paciente, Medico medico, LocalDateTime dataHora) {
        this.paciente = paciente;
        this.medico = medico;
        this.dataHora = dataHora;
    }

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

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
}
