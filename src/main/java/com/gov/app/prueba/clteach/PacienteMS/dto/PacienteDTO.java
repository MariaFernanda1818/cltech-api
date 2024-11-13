package com.gov.app.prueba.clteach.PacienteMS.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO (Data Transfer Object) que representa la información básica de un paciente.
 * <p>
 * Esta clase se utiliza para transferir datos relacionados con un paciente,
 * como su nombre y el número de orden asociado.
 * </p>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PacienteDTO {

    /**
     * Nombre completo del paciente.
     * Ejemplo: "Juan Pérez".
     */
    private String nombrePaciente;

    /**
     * Número de orden asociado al paciente.
     * Este número identifica la solicitud o registro del paciente.
     * Ejemplo: 12345.
     */
    private Integer numeroOrden;
}
