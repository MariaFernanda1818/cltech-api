package com.gov.app.prueba.clteach.PacienteMS.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamenDTO {

    private String codigoExamen;

    private String resultadoExamen;

    private PacienteDTO pacienteFk;
}
