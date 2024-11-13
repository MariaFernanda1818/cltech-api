package com.gov.app.prueba.clteach.PacienteMS.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO (Data Transfer Object) que representa la información requerida para registrar un paciente y su examen.
 * <p>
 * Esta clase encapsula los datos básicos necesarios para realizar el registro, incluyendo
 * el nombre del paciente, número de orden, código del examen y resultado del examen.
 * Incluye validaciones con anotaciones de Jakarta para garantizar que los datos no sean nulos ni estén en blanco.
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
     * </p>
     * Ejemplo: "12345".
     */
    @NotNull
    @NotBlank
    private String numeroOrden;

    /**
     * Código único que identifica el examen asociado al paciente.
     * <p>
     * Este campo es obligatorio y no puede ser nulo ni estar en blanco.
     * </p>
     * Ejemplo: "EX123".
     */
    @NotNull
    @NotBlank
    private String codigoExamen;

    /**
     * Resultado del examen realizado al paciente.
     * <p>
     * Este campo es obligatorio y no puede ser nulo ni estar en blanco.
     * </p>
     * Ejemplo: "Positivo" o "7.5".
     */
    @NotNull
    @NotBlank
    private String resultadoExamen;
}
