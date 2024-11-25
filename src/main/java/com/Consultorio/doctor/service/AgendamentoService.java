package com.Consultorio.doctor.service;

import com.Consultorio.doctor.exception.HorarioIndisponivelException;
import com.Consultorio.doctor.model.Agendamento;
import com.Consultorio.doctor.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    // Método para agendar uma consulta
    public Agendamento agendarConsulta(Agendamento agendamento) {
        // Verifica se o horário está disponível
        boolean disponivel = verificarDisponibilidade(agendamento.getDataHora());
        if (!disponivel) {
            throw new HorarioIndisponivelException("Horário já ocupado!");
        }
        return agendamentoRepository.save(agendamento);
    }

    // Método para listar todos os agendamentos
    public List<Agendamento> listarAgendamentos() {
        return agendamentoRepository.findAll();
    }

    // Método para verificar se o horário está disponível
    public boolean verificarDisponibilidade(LocalDateTime dataHora) {
        return agendamentoRepository.findByDataHora(dataHora).isEmpty();
    }
}
