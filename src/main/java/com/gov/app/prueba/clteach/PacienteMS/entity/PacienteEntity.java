package com.gov.app.prueba.clteach.PacienteMS.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Entidad JPA que representa la tabla "paciente" en la base de datos.
 * <p>
 * Esta clase mapea los datos básicos de un paciente, incluyendo su nombre y número de orden.
 * Utiliza anotaciones de JPA para definir las propiedades y su correspondencia con las columnas de la tabla.
 * </p>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "paciente")
public class PacienteEntity {

    /**
     * Identificador único del paciente.
     * <p>
     * Este campo es la clave primaria de la tabla "paciente", generada automáticamente.
     * </p>
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paciente")
    private Long idPaciente;

    /**
     * Nombre completo del paciente.
     * <p>
     * Este campo es obligatorio y tiene un límite de 100 caracteres.
     * </p>
     * Ejemplo: "Juan Pérez".
     */
    @Column(name = "nombre_paciente", nullable = false, length = 100)
    private String nombrePaciente;

    /**
     * Número de orden asociado al paciente.
     * <p>
     * Este campo es obligatorio y representa el identificador único asociado al registro o solicitud del paciente.
     * </p>
     * Ejemplo: 12345.
     */
    @Column(name = "numero_orden_paciente", nullable = false)
    private String numeroOrden;

}
