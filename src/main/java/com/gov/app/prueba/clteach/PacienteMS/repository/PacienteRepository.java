package com.gov.app.prueba.clteach.PacienteMS.repository;

import com.gov.app.prueba.clteach.PacienteMS.entity.PacienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio JPA para gestionar operaciones CRUD de la entidad {@link PacienteEntity}.
 * <p>
 * Proporciona métodos predefinidos y personalizados para interactuar con la base de datos
 * relacionada con la entidad "Paciente".
 * </p>
 */
@Repository
public interface PacienteRepository extends JpaRepository<PacienteEntity, Long> {

    /**
     * Verifica si existe un paciente con un número de orden específico.
     *
     * @param numeroOrden Número de orden asociado al paciente.
     * @return {@code true} si existe un paciente con el número de orden proporcionado,
     * de lo contrario, {@code false}.
     */
    Boolean existsByNumeroOrden(String numeroOrden);

}
