package com.Consultorio.doctor.DTO;

import com.Consultorio.doctor.model.Consulta;

public class ConsultaDTO {
    private Long id;
    private String data;
    private String hora;
    private String nomePaciente;
    private String emailPaciente;
    private String nomeMedico;
    private String especialidadeMedico;

    // Construtor
    public ConsultaDTO(Consulta consulta) {
        this.id = consulta.getId();
        this.data = consulta.getData().toString();
        this.hora = consulta.getHora().toString();
        this.nomePaciente = consulta.getPaciente().getNome();
        this.emailPaciente = consulta.getPaciente().getEmail();
        this.nomeMedico = consulta.getMedico().getNome();
        this.especialidadeMedico = consulta.getMedico().getEspecialidade();
    }

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public String getEmailPaciente() {
        return emailPaciente;
    }

    public void setEmailPaciente(String emailPaciente) {
        this.emailPaciente = emailPaciente;
    }

    public String getNomeMedico() {
        return nomeMedico;
    }

    public void setNomeMedico(String nomeMedico) {
        this.nomeMedico = nomeMedico;
    }

    public String getEspecialidadeMedico() {
        return especialidadeMedico;
    }

    public void setEspecialidadeMedico(String especialidadeMedico) {
        this.especialidadeMedico = especialidadeMedico;
    }
}

