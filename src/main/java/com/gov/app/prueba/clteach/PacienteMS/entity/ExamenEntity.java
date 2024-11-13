package com.gov.app.prueba.clteach.PacienteMS.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "examenes")
public class ExamenEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo_examen", nullable = false, length = 15)
    private String codigoExamen;

    @Column(name = "resultado_examen", nullable = false, length = 35)
    private String resultadoExamen;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "paciente_fk", nullable = false)
    private PacienteEntity pacienteFk;
}
