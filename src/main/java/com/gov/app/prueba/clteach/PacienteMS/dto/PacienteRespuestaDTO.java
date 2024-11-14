package com.gov.app.prueba.clteach.PacienteMS.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

/**
 * DTO (Data Transfer Object) que extiende la información básica de un paciente para incluir sus exámenes asociados.
 * <p>
 * Esta clase hereda de {@link PacienteDTO} y agrega una lista de exámenes asociados al paciente,
 * representados mediante objetos de tipo {@link ExamenDTO}.
 * </p>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class PacienteRespuestaDTO extends PacienteDTO {

    /**
     * Lista de exámenes asociados al paciente.
     * <p>
     * Cada examen en la lista incluye detalles como el código del examen y su resultado.
     * </p>
     */
    private List<ExamenDTO> examenes;
}
