package com.gov.app.prueba.clteach.PacienteMS.repository;

import com.gov.app.prueba.clteach.PacienteMS.entity.ExamenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio JPA para gestionar operaciones CRUD de la entidad {@link ExamenEntity}.
 * <p>
 * Esta interfaz extiende {@link JpaRepository}, lo que proporciona métodos predefinidos
 * para realizar operaciones de persistencia, como guardar, buscar, actualizar y eliminar
 * registros en la base de datos relacionados con la entidad "Examen".
 * </p>
 */
@Repository
public interface ExamenRepository extends JpaRepository<ExamenEntity, Long> {
}
