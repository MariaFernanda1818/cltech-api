package com.gov.app.prueba.clteach.PacienteMS.service;

import com.gov.app.prueba.clteach.PacienteMS.dto.PacienteDTO;
import com.gov.app.prueba.clteach.PacienteMS.dto.PacienteRequestDTO;
import com.gov.app.prueba.clteach.PacienteMS.dto.RespuestaGeneralDTO;

public interface IGuardarPacienteService {

    RespuestaGeneralDTO validacionesPaciente(PacienteRequestDTO pacienteRequestDTO)  throws Exception;

}
