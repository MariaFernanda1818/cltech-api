package com.gov.app.prueba.clteach.PacienteMS.controller;

import com.gov.app.prueba.clteach.PacienteMS.dto.PacienteRequestDTO;
import com.gov.app.prueba.clteach.PacienteMS.dto.RespuestaGeneralDTO;
import com.gov.app.prueba.clteach.PacienteMS.service.IConsultarPacienteService;
import com.gov.app.prueba.clteach.PacienteMS.service.IGuardarPacienteService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PacienteControllerTest {

    @InjectMocks
    private PacienteController pacienteController;

    @Mock
    private IGuardarPacienteService guardarPacienteService;

    @Mock
    private IConsultarPacienteService consultarPacienteService;


    @Test
    void testGuardarPacienteSuccess() throws Exception {
        // Arrange
        PacienteRequestDTO pacienteRequestDTO = new PacienteRequestDTO();
        pacienteRequestDTO.setNombres("Juan Pérez");
        pacienteRequestDTO.setNumeroOrden("12345");
        pacienteRequestDTO.setCodigoExamen("EX001");
        pacienteRequestDTO.setResultadoExamen("Positivo");

        RespuestaGeneralDTO respuesta = new RespuestaGeneralDTO();
        respuesta.setCodigo(HttpStatus.CREATED.value());
        respuesta.setStatus(HttpStatus.CREATED.name());
        respuesta.setMessage("El paciente y los exámenes se han guardado correctamente");

        when(guardarPacienteService.validacionesPaciente(any(PacienteRequestDTO.class))).thenReturn(respuesta);

        // Act
        ResponseEntity<RespuestaGeneralDTO> response = pacienteController.guardarPaciente(pacienteRequestDTO);

        // Assert
        assertEquals(HttpStatus.CREATED.value(), response.getStatusCodeValue());
        assertEquals("El paciente y los exámenes se han guardado correctamente", response.getBody().getMessage());
        verify(guardarPacienteService, times(1)).validacionesPaciente(any(PacienteRequestDTO.class));
    }

    @Test
    void testConsultarPacientesSuccess() {
        // Arrange
        RespuestaGeneralDTO respuesta = new RespuestaGeneralDTO();
        respuesta.setCodigo(HttpStatus.OK.value());
        respuesta.setStatus(HttpStatus.OK.name());
        respuesta.setMessage("Consulta exitosa");
        respuesta.setData("Listado de pacientes");

        when(consultarPacienteService.consultarPacientes()).thenReturn(respuesta);

        // Act
        ResponseEntity<RespuestaGeneralDTO> response = pacienteController.consultarPacientes();

        // Assert
        assertEquals(HttpStatus.OK.value(), response.getStatusCodeValue());
        assertEquals("Consulta exitosa", response.getBody().getMessage());
        verify(consultarPacienteService, times(1)).consultarPacientes();
    }
}
