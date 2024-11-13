package com.gov.app.prueba.clteach.PacienteMS.repository;

import com.gov.app.prueba.clteach.PacienteMS.entity.PacienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<PacienteEntity, Long> {
}
