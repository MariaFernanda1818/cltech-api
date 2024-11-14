package com.gov.app.prueba.clteach.PacienteMS.repository;

import com.gov.app.prueba.clteach.PacienteMS.entity.ExamenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

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

    /**
     * Obtiene los exámenes asociados a un paciente específico.
     *
     * @param idPaciente ID del paciente cuyos exámenes se desean consultar.
     * @return Lista de arreglos de objetos (<code>Object[]</code>) con los datos del examen:
     * <code>idExamen</code>, <code>codigoExamen</code> y <code>resultadoExamen</code>.
     */
    @Query("""
        SELECT  examen.idExamen,examen.codigoExamen, examen.resultadoExamen FROM ExamenEntity examen WHERE examen.pacienteFk.idPaciente = :idPaciente
    """)
    List<Object[]> findAllPaciente(@Param("idPaciente") Long idPaciente);

}
