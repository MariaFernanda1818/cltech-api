package com.gov.app.prueba.clteach.PacienteMS.util.helper;

/**
 * Clase que define constantes utilizadas en la aplicación.
 * <p>
 * Esta clase centraliza los mensajes y textos constantes para evitar redundancias y
 * facilitar el mantenimiento del código. Las constantes incluyen mensajes de error,
 * éxito y validaciones relacionados con las operaciones de pacientes y exámenes.
 * </p>
 */
public class Constantes {

    /**
     * Mensaje de error para conversiones de tipos.
     * <p>
     * Se utiliza cuando ocurre un error al intentar convertir un tipo de dato a otro.
     * </p>
     * Ejemplo: "Error de conversión de tipos: [detalles del error]".
     */
    public static final String ERROR_CONVERSION_TIPOS = "Error de conversión de tipos: ";

    /**
     * Mensaje de éxito para la consulta de pacientes.
     * <p>
     * Indica que los pacientes fueron consultados correctamente.
     * </p>
     */
    public static final String CONSULTA_CORRECTAMENTE = "Se han consultado correctamente los pacientes";

    /**
     * Mensaje genérico de error al consultar pacientes.
     * <p>
     * Se utiliza en los logs para registrar fallos en la operación de consulta.
     * </p>
     */
    public static final String ERROR_CONSULTA = "Error al consultar los pacientes";

    /**
     * Mensaje de error para la interfaz del usuario al fallar la consulta de pacientes.
     * <p>
     * Indica que hubo un error al intentar realizar la consulta.
     * </p>
     */
    public static final String ERROR_CONSULTA_MENSAJE = "Hubo un error en la consulta de los pacientes";

    /**
     * Mensaje de validación para números de orden ya registrados.
     * <p>
     * Se utiliza para informar que un número de orden ya existe en la base de datos.
     * </p>
     */
    public static final String NUMERO_ORDEN_REGISTRADO = "El numero de orden del paciente ya fue registrado";

    /**
     * Mensaje de éxito al guardar un paciente y sus exámenes.
     * <p>
     * Indica que el paciente y los exámenes asociados fueron almacenados correctamente.
     * </p>
     */
    public static final String PACIENTE_EXAMENES_GUARDADOS = "El paciente y los exámenes se han guardado correctamente";

    /**
     * Mensaje de error al guardar un paciente y sus exámenes.
     * <p>
     * Indica que ocurrió un error durante la operación de guardado.
     * </p>
     */
    public static final String ERRROR_GUARDADO_PACIENTE_EXAMENES = "Error al guardar el paciente y los exámenes";

}
