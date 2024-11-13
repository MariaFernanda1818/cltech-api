package com.gov.app.prueba.clteach.PacienteMS.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class PacienteResponseDTO extends PacienteDTO{

    private List<ExamenDTO> examenes;

    public PacienteResponseDTO(PacienteDTO pacienteDTO) {
        super(pacienteDTO.getNombrePaciente(), pacienteDTO.getNumeroOrden());
        examenes = new ArrayList<>();
    }
}
