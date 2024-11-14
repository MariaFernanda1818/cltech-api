package com.gov.app.prueba.clteach.PacienteMS.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * DTO (Data Transfer Object) que representa la información básica de un paciente.
 * <p>
 * Esta clase se utiliza para transferir datos relacionados con un paciente,
 * como su identificador, nombre completo y el número de orden asociado.
 * Es empleada en la capa de transferencia de datos para facilitar la comunicación entre
 * las distintas capas de la aplicación.
 * </p>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class PacienteDTO {

    /**
     * Identificador único del paciente.
     * <p>
     * Este campo corresponde al identificador único del paciente en la base de datos.
     * </p>
     * Ejemplo: 1.
     */
    private Long idPaciente;

    /**
     * Nombre completo del paciente.
     * <p>
     * Representa el nombre completo del paciente registrado en el sistema.
     * </p>
     * Ejemplo: "Juan Pérez".
     */
    private String nombrePaciente;

    /**
     * Número de orden asociado al paciente.
     * <p>
     * Este número identifica la solicitud o el registro del paciente, permitiendo
     * realizar búsquedas o consultas específicas.
     * </p>
     * Ejemplo: 12345.
     */
    private String numeroOrden;
}
