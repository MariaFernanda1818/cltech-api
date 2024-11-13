package com.gov.app.prueba.clteach.PacienteMS.controller;

import com.gov.app.prueba.clteach.PacienteMS.dto.PacienteDTO;
import com.gov.app.prueba.clteach.PacienteMS.dto.PacienteRequestDTO;
import com.gov.app.prueba.clteach.PacienteMS.dto.RespuestaGeneralDTO;
import com.gov.app.prueba.clteach.PacienteMS.service.IConsultarPacienteService;
import com.gov.app.prueba.clteach.PacienteMS.service.IGuardarPacienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST para la gestión de pacientes.
 * <p>
 * Proporciona endpoints para guardar pacientes y consultar la lista de pacientes disponibles.
 * Utiliza los servicios {@link IGuardarPacienteService} e {@link IConsultarPacienteService}
 * para delegar la lógica de negocio.
 * </p>
 */
@RestController
@RequestMapping("/pacientes")
@RequiredArgsConstructor
public class PacienteController {

    /**
     * Servicio para realizar validaciones y guardar pacientes.
     */
    private final IGuardarPacienteService pacienteService;

    /**
     * Servicio para consultar pacientes registrados.
     */
    private final IConsultarPacienteService iConsultarPacienteService;

    /**
     * Endpoint para guardar un paciente.
     * <p>
     * Recibe un objeto {@link PacienteRequestDTO} con los datos del paciente y realiza las validaciones necesarias
     * antes de guardar la información. Devuelve un objeto {@link RespuestaGeneralDTO} con el resultado de la operación.
     * </p>
     *
     * @param pacienteRequestDTO el objeto con los datos del paciente a guardar.
     * @return una respuesta HTTP con el resultado de la operación.
     * @throws Exception si ocurre algún error durante el proceso de validación o guardado.
     */
    @PostMapping("/guardar")
    public ResponseEntity<RespuestaGeneralDTO> guardarPaciente(
            @Valid @RequestBody PacienteRequestDTO pacienteRequestDTO
    ) throws Exception {
        RespuestaGeneralDTO respuestaGeneralDTO = pacienteService.validacionesPaciente(pacienteRequestDTO);
        return ResponseEntity.status(HttpStatusCode.valueOf(respuestaGeneralDTO.getCodigo())).body(respuestaGeneralDTO);
    }

    /**
     * Endpoint para consultar todos los pacientes registrados.
     * <p>
     * Este método utiliza el servicio {@link IConsultarPacienteService} para obtener la lista de pacientes.
     * Devuelve un objeto {@link RespuestaGeneralDTO} con los datos de los pacientes y el estado de la operación.
     * </p>
     *
     * @return una respuesta HTTP con la lista de pacientes o el estado de la operación.
     */
    @GetMapping("/consulta")
    public ResponseEntity<RespuestaGeneralDTO> consultarPacientes() {
        RespuestaGeneralDTO respuestaGeneralDTO = iConsultarPacienteService.consultarPacientes();
        return ResponseEntity.status(respuestaGeneralDTO.getCodigo()).body(respuestaGeneralDTO);
    }
}
