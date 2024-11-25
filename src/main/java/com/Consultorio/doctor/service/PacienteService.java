package com.Consultorio.doctor.service;

import com.Consultorio.doctor.model.Paciente;
import com.Consultorio.doctor.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    // Salvar ou atualizar um paciente
    public Paciente salvarPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    // Buscar todos os pacientes
    public List<Paciente> listarPacientes() {
        return pacienteRepository.findAll();
    }

    // Buscar um paciente pelo ID
    public Optional<Paciente> buscarPacientePorId(Long id) {
        return pacienteRepository.findById(id);
    }

    // Deletar um paciente
    public void deletarPaciente(Long id) {
        pacienteRepository.deleteById(id);
    }
}
