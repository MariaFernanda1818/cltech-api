package com.gov.app.prueba.clteach.PacienteMS.repository;

import com.gov.app.prueba.clteach.PacienteMS.entity.ExamenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamenRepository extends JpaRepository<ExamenEntity, Long> {
}
