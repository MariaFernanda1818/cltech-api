package com.gov.app.prueba.clteach.PacienteMS.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entidad JPA que representa la tabla "examen" en la base de datos.
 * <p>
 * Esta clase mapea los datos de un examen, incluyendo su código, resultado y la relación con un paciente.
 * Utiliza anotaciones de JPA para definir las propiedades y su correspondencia con las columnas de la tabla.
 * </p>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "examen")
public class ExamenEntity {

    /**
     * Identificador único del examen.
     * <p>
     * Este campo es la clave primaria de la tabla "examen", generada automáticamente.
     * </p>
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_examen")
    private Long idExamen;

    /**
     * Código único que identifica el examen.
     * <p>
     * Este campo es obligatorio y tiene un límite de 15 caracteres.
     * </p>
     * Ejemplo: "EX12345".
     */
    @Column(name = "codigo_examen", nullable = false, length = 15)
    private String codigoExamen;

    /**
     * Resultado del examen.
     * <p>
     * Este campo es obligatorio y tiene un límite de 35 caracteres.
     * </p>
     * Ejemplo: "Positivo" o "7.5".
     */
    @Column(name = "resultado_examen", nullable = false, length = 35)
    private String resultadoExamen;

    /**
     * Relación con la entidad {@link PacienteEntity}.
     * <p>
     * Define una relación de muchos-a-uno (ManyToOne) con la entidad "paciente".
     * Este campo representa el paciente al que pertenece el examen.
     * </p>
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "paciente_fk", nullable = false)
    private PacienteEntity pacienteFk;
}
