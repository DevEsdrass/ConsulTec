package com.Consultorio.doctor.controller;

import com.Consultorio.doctor.DTO.ConsultaDTO;
import com.Consultorio.doctor.model.Consulta;
import com.Consultorio.doctor.model.Medico;
import com.Consultorio.doctor.model.Paciente;
import com.Consultorio.doctor.repository.ConsultaRepository;
import com.Consultorio.doctor.repository.MedicoRepository;
import com.Consultorio.doctor.repository.PacienteRepository;
import com.Consultorio.doctor.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private EmailService emailService;

    // Método POST: Agendar consulta
    @PostMapping
    public ResponseEntity<Consulta> agendarConsulta(@RequestBody Consulta consulta) {
        try {
            if (consulta.getPaciente() == null || consulta.getMedico() == null || consulta.getData() == null || consulta.getHora() == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // Retorna erro se algum campo obrigatório estiver faltando
            }

            // Recupera o paciente e o médico completos do banco de dados usando os IDs fornecidos
            Optional<Paciente> pacienteOptional = pacienteRepository.findById(consulta.getPaciente().getId());
            Optional<Medico> medicoOptional = medicoRepository.findById(consulta.getMedico().getId());

            if (pacienteOptional.isEmpty() || medicoOptional.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Retorna 404 se paciente ou médico não encontrados
            }

            consulta.setPaciente(pacienteOptional.get());
            consulta.setMedico(medicoOptional.get());

            // Salva a nova consulta
            Consulta novaConsulta = consultaRepository.save(consulta);

            // Envia o e-mail de confirmação
            String toEmail = novaConsulta.getPaciente().getEmail();
            if (toEmail != null && !toEmail.isEmpty()) {
                String subject = "Confirmação de Consulta";
                String body = "Sua consulta foi agendada para o dia " + novaConsulta.getData() + " às " + novaConsulta.getHora() + ".";
                emailService.enviarEmail(toEmail, subject, body);
            }

            return new ResponseEntity<>(novaConsulta, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultaDTO> buscarConsulta(@PathVariable Long id) {
        System.out.println("Buscando consulta com ID: " + id);  // Log para verificar o ID

        Optional<Consulta> consultaOptional = consultaRepository.findById(id);
        if (consultaOptional.isEmpty()) {
            System.out.println("Consulta não encontrada com ID: " + id);  // Log se consulta não for encontrada
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Consulta consulta = consultaOptional.get();
        ConsultaDTO consultaDTO = new ConsultaDTO(consulta);
        System.out.println("Consulta encontrada: " + consultaDTO);  // Log para verificar a consulta encontrada

        return new ResponseEntity<>(consultaDTO, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelarConsulta(@PathVariable Long id) {
        try {
            // Verifica se a consulta existe no banco de dados
            if (consultaRepository.existsById(id)) {
                consultaRepository.deleteById(id); // Exclui a consulta
                return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Retorna 204 (No Content) se bem-sucedido
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Retorna 404 se a consulta não for encontrada
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Retorna 500 em caso de erro
        }
    }


}
