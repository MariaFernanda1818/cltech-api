package com.gov.app.prueba.clteach.PacienteMS.controller;

import com.gov.app.prueba.clteach.PacienteMS.dto.PacienteDTO;
import com.gov.app.prueba.clteach.PacienteMS.dto.PacienteRequestDTO;
import com.gov.app.prueba.clteach.PacienteMS.dto.RespuestaGeneralDTO;
import com.gov.app.prueba.clteach.PacienteMS.service.IConsultarPacienteService;
import com.gov.app.prueba.clteach.PacienteMS.service.IGuardarPacienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
@RequiredArgsConstructor
public class PacienteController {

    private final IGuardarPacienteService pacienteService;

    private final IConsultarPacienteService iConsultarPacienteService;

    @PostMapping("/guardar")
    public ResponseEntity<RespuestaGeneralDTO> guardarPaciente(
            @Valid @RequestBody PacienteRequestDTO pacienteRequestDTO
    ) throws Exception {
        RespuestaGeneralDTO respuestaGeneralDTO = pacienteService.validacionesPaciente(pacienteRequestDTO);
        return ResponseEntity.status(respuestaGeneralDTO.getStatus()).body(respuestaGeneralDTO);
    }

    @GetMapping("/consulta")
    public ResponseEntity<RespuestaGeneralDTO> consultarPacientes() {
        RespuestaGeneralDTO respuestaGeneralDTO = iConsultarPacienteService.consultarPacientes();
        return ResponseEntity.status(respuestaGeneralDTO.getStatus()).body(respuestaGeneralDTO);
    }
}
