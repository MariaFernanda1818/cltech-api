package com.gov.app.prueba.clteach.PacienteMS.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class PacienteDTO {

    private String nombrePaciente;

    private Integer numeroOrden;

}
