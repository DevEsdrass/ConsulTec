package com.Consultorio.doctor.controller;

import com.Consultorio.doctor.model.Medico;
import com.Consultorio.doctor.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    // Método GET: Lista médicos por especialidade
    @GetMapping
    public List<Medico> listarPorEspecialidade(@RequestParam String especialidade) {
        return medicoRepository.findByEspecialidade(especialidade);
    }

    // Método POST: Adiciona um novo médico
    @PostMapping
    public ResponseEntity<Medico> adicionarMedico(@RequestBody Medico medico) {
        Medico novoMedico = medicoRepository.save(medico);
        return new ResponseEntity<>(novoMedico, HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarMedico(@PathVariable Long id) {
        if (medicoRepository.existsById(id)) {
            medicoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}






