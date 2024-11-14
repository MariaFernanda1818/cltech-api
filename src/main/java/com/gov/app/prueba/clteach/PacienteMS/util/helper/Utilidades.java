package com.gov.app.prueba.clteach.PacienteMS.util.helper;

import java.util.Objects;
import java.util.Optional;

import static com.gov.app.prueba.clteach.PacienteMS.util.helper.Constantes.ERROR_CONVERSION_TIPOS;

/**
 * Clase de utilidades para operaciones comunes relacionadas con la validación y conversión de tipos.
 * <p>
 * Esta clase proporciona métodos genéricos y reutilizables para operaciones auxiliares
 * que son utilizadas en distintas partes de la aplicación.
 * </p>
 */
public class Utilidades {

    /**
     * Verifica y convierte un objeto al tipo especificado si es posible.
     * <p>
     * Este método intenta convertir el objeto dado al tipo objetivo especificado.
     * Si la conversión es exitosa, devuelve el objeto convertido en un {@link Optional}.
     * Si no es posible realizar la conversión, devuelve un {@link Optional} vacío.
     * </p>
     *
     * @param obj   El objeto a verificar y convertir.
     * @param clazz La clase del tipo objetivo al cual se desea convertir el objeto.
     * @param <T>   El tipo genérico objetivo.
     * @return Un {@link Optional} que contiene el objeto convertido si la conversión es exitosa,
     * o vacío si no es convertible o el objeto es nulo.
     * @throws IllegalArgumentException Si ocurre un error durante la conversión.
     *                                  El mensaje incluye detalles específicos del error.
     * @see Optional
     */
    public static <T> Optional<T> checkType(Object obj, Class<T> clazz) {
        if (Objects.isNull(obj)) {
            return Optional.empty();
        }

        try {
            return switch (clazz.getSimpleName()) {
                case "String" -> Optional.of(clazz.cast(String.valueOf(obj)));
                case "Integer" -> Optional.of(clazz.cast(Integer.valueOf(obj.toString())));
                case "Double" -> Optional.of(clazz.cast(Double.valueOf(obj.toString())));
                case "Long" -> Optional.of(clazz.cast(Long.valueOf(obj.toString())));
                default -> Optional.empty();
            };
        } catch (Exception e) {
            throw new IllegalArgumentException(ERROR_CONVERSION_TIPOS + e.getMessage(), e);
        }
    }
}
