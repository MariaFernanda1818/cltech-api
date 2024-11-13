package com.gov.app.prueba.clteach.PacienteMS.repository;

import com.gov.app.prueba.clteach.PacienteMS.entity.PacienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio JPA para gestionar operaciones CRUD de la entidad {@link PacienteEntity}.
 * <p>
 * Esta interfaz extiende {@link JpaRepository}, lo que proporciona métodos predefinidos
 * para realizar operaciones de persistencia, como guardar, buscar, actualizar y eliminar
 * registros en la base de datos relacionados con la entidad "Paciente".
 * </p>
 */
@Repository
public interface PacienteRepository extends JpaRepository<PacienteEntity, Long> {
}
