package com.Consultorio.doctor.repository;

import com.Consultorio.doctor.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

}
