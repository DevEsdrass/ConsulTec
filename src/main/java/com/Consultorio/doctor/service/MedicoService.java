package com.Consultorio.doctor.service;

import com.Consultorio.doctor.model.Medico;
import com.Consultorio.doctor.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    // Salvar um médico
    public Medico salvarMedico(Medico medico) {
        return medicoRepository.save(medico);
    }

    // Listar todos os médicos
    public List<Medico> listarMedicos() {
        return medicoRepository.findAll();
    }
}
