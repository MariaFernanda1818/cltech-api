package com.gov.app.prueba.clteach.PacienteMS.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO (Data Transfer Object) que representa un examen realizado a un paciente.
 * <p>
 * Esta clase encapsula la información de un examen, incluyendo el código del examen,
 * su resultado y la relación con el paciente al que pertenece.
 * </p>
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamenDTO {

    /**
     * Código único que identifica el examen.
     * Ejemplo: "EX12345".
     */
    private String codigoExamen;

    /**
     * Resultado del examen.
     * Ejemplo: "Positivo" o "7.5".
     */
    private String resultadoExamen;

    /**
     * Información del paciente asociado al examen.
     * Representado mediante un objeto {@link PacienteDTO}.
     */
    private PacienteDTO pacienteFk;
}
