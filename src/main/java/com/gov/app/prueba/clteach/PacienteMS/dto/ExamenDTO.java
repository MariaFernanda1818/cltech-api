package com.gov.app.prueba.clteach.PacienteMS.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO (Data Transfer Object) que representa un examen realizado a un paciente.
 * <p>
 * Esta clase encapsula la información de un examen, incluyendo su identificador único,
 * el código del examen, el resultado obtenido y la relación con el paciente asociado.
 * Es utilizada para transferir datos entre las diferentes capas del sistema.
 * </p>
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamenDTO {

    /**
     * Identificador único del examen.
     * <p>
     * Este campo representa el ID del examen en la base de datos.
     * </p>
     * Ejemplo: 123.
     */
    private Long idExamen;

    /**
     * Código único que identifica el examen.
     * <p>
     * Este campo debe contener un valor no nulo y no vacío.
     * </p>
     * Ejemplo: "EX12345".
     */
    @NotNull
    @NotBlank
    private String codigoExamen;

    /**
     * Resultado del examen.
     * <p>
     * Este campo debe contener un valor no nulo y no vacío, representando
     * el resultado obtenido del examen.
     * </p>
     * Ejemplo: "Positivo" o "7.5".
     */
    @NotNull
    @NotBlank
    private String resultadoExamen;

    /**
     * Información del paciente asociado al examen.
     * <p>
     * Este campo representa la relación entre el examen y el paciente,
     * encapsulada en un objeto {@link PacienteDTO}.
     * </p>
     */
    private PacienteDTO pacienteFk;
}
