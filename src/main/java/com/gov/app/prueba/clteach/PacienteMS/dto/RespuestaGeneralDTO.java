package com.gov.app.prueba.clteach.PacienteMS.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * DTO (Data Transfer Object) que encapsula la estructura de una respuesta genérica en el sistema.
 * <p>
 * Esta clase se utiliza para estandarizar las respuestas enviadas desde los servicios de la aplicación,
 * proporcionando información sobre el estado, código, datos y mensajes relacionados con la operación realizada.
 * </p>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RespuestaGeneralDTO implements Serializable {

    /**
     * Estado textual de la respuesta.
     * <p>
     * Representa el estado de la operación, como "SUCCESS" o "ERROR".
     * </p>
     * Ejemplo: "SUCCESS".
     */
    private String status;

    /**
     * Código numérico de la respuesta.
     * <p>
     * Usualmente corresponde a un código HTTP estándar o personalizado.
     * </p>
     * Ejemplo: 200, 400, 500.
     */
    private int codigo;

    /**
     * Datos adicionales relacionados con la respuesta.
     * <p>
     * Este campo puede contener cualquier tipo de objeto relevante, como información procesada
     * o detalles específicos de la operación.
     * </p>
     * Ejemplo: Un objeto de tipo `PacienteDTO` o una lista de objetos.
     */
    private Object data;

    /**
     * Mensaje descriptivo de la respuesta.
     * <p>
     * Proporciona información adicional sobre el resultado de la operación, como un mensaje
     * de éxito o una descripción del error ocurrido.
     * </p>
     * Ejemplo: "Operación realizada con éxito" o "Error en los datos enviados".
     */
    private String message;
}
