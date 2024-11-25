package com.Consultorio.doctor.repository;

import com.Consultorio.doctor.model.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
    Optional<Agendamento> findByDataHora(LocalDateTime dataHora);
}
