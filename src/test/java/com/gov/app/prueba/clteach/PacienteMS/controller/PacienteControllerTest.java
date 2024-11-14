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

        RespuestaGeneralDTO respuesta = new RespuestaGeneralDTO();
        respuesta.setCodigo(201); // Código de respuesta HTTP para "Created"
        respuesta.setStatus("CREATED");
        respuesta.setMessage("El paciente y los exámenes se han guardado correctamente");

        when(guardarPacienteService.validacionesPaciente(any(PacienteRequestDTO.class))).thenReturn(respuesta);

        // Act
        ResponseEntity<RespuestaGeneralDTO> response = pacienteController.guardarPaciente(pacienteRequestDTO);

        // Assert
        assertEquals(201, response.getStatusCodeValue());
        assertEquals("CREATED", response.getBody().getStatus());
        assertEquals("El paciente y los exámenes se han guardado correctamente", response.getBody().getMessage());
        verify(guardarPacienteService, times(1)).validacionesPaciente(any(PacienteRequestDTO.class));
    }

    @Test
    void testGuardarPacienteFailure() throws Exception {
        // Arrange
        PacienteRequestDTO pacienteRequestDTO = new PacienteRequestDTO();
        pacienteRequestDTO.setNombres("Juan Pérez");
        pacienteRequestDTO.setNumeroOrden("12345");

        RespuestaGeneralDTO respuesta = new RespuestaGeneralDTO();
        respuesta.setCodigo(400); // Código de respuesta HTTP para "Bad Request"
        respuesta.setStatus("BAD_REQUEST");
        respuesta.setMessage("El número de orden ya fue registrado");

        when(guardarPacienteService.validacionesPaciente(any(PacienteRequestDTO.class))).thenReturn(respuesta);

        // Act
        ResponseEntity<RespuestaGeneralDTO> response = pacienteController.guardarPaciente(pacienteRequestDTO);

        // Assert
        assertEquals(400, response.getStatusCodeValue());
        assertEquals("BAD_REQUEST", response.getBody().getStatus());
        assertEquals("El número de orden ya fue registrado", response.getBody().getMessage());
        verify(guardarPacienteService, times(1)).validacionesPaciente(any(PacienteRequestDTO.class));
    }

    @Test
    void testConsultarPacientesSuccess() {
        // Arrange
        RespuestaGeneralDTO respuesta = new RespuestaGeneralDTO();
        respuesta.setCodigo(200); // Código de respuesta HTTP para "OK"
        respuesta.setStatus("OK");
        respuesta.setMessage("Consulta exitosa");
        respuesta.setData("Listado de pacientes");

        when(consultarPacienteService.consultarPacientes()).thenReturn(respuesta);

        // Act
        ResponseEntity<RespuestaGeneralDTO> response = pacienteController.consultarPacientes();

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("OK", response.getBody().getStatus());
        assertEquals("Consulta exitosa", response.getBody().getMessage());
        assertEquals("Listado de pacientes", response.getBody().getData());
        verify(consultarPacienteService, times(1)).consultarPacientes();
    }

    @Test
    void testConsultarPacientesFailure() {
        // Arrange
        RespuestaGeneralDTO respuesta = new RespuestaGeneralDTO();
        respuesta.setCodigo(500); // Código de respuesta HTTP para "Internal Server Error"
        respuesta.setStatus("INTERNAL_SERVER_ERROR");
        respuesta.setMessage("Error al consultar los pacientes");

        when(consultarPacienteService.consultarPacientes()).thenReturn(respuesta);

        // Act
        ResponseEntity<RespuestaGeneralDTO> response = pacienteController.consultarPacientes();

        // Assert
        assertEquals(500, response.getStatusCodeValue());
        assertEquals("INTERNAL_SERVER_ERROR", response.getBody().getStatus());
        assertEquals("Error al consultar los pacientes", response.getBody().getMessage());
        verify(consultarPacienteService, times(1)).consultarPacientes();
    }
}
