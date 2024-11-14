package com.gov.app.prueba.clteach.PacienteMS.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * DTO (Data Transfer Object) que representa la información requerida para registrar un paciente y su examen.
 * <p>
 * Esta clase encapsula los datos básicos necesarios para realizar el registro, incluyendo
 * el nombre del paciente, número de orden, y una lista de exámenes asociados.
 * Las anotaciones de validación de Jakarta garantizan que los datos no sean nulos ni estén en blanco.
 * </p>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PacienteRequestDTO {

    /**
     * Nombres completos del paciente.
     * <p>
     * Este campo es obligatorio y no puede ser nulo ni estar en blanco.
     * Representa el nombre completo del paciente que se desea registrar.
     * </p>
     * Ejemplo: "Juan Pérez".
     */
    @NotNull
    @NotBlank
    private String nombres;

    /**
     * Número de orden asociado al paciente.
     * <p>
     * Este campo es obligatorio y no puede ser nulo ni estar en blanco.
     * Representa un identificador único para la solicitud del paciente.
     * </p>
     * Ejemplo: "12345".
     */
    @NotNull
    @NotBlank
    private String numeroOrden;

    /**
     * Lista de exámenes asociados al paciente.
     * <p>
     * Este campo es obligatorio y no puede ser nulo. Contiene la información de los
     * exámenes que se deben registrar junto con el paciente.
     * </p>
     */
    @NotNull
    private List<ExamenDTO> examenes;
}
