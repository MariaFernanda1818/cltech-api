package com.gov.app.prueba.clteach.PacienteMS.service;

import com.gov.app.prueba.clteach.PacienteMS.dto.ExamenDTO;
import com.gov.app.prueba.clteach.PacienteMS.dto.PacienteDTO;
import com.gov.app.prueba.clteach.PacienteMS.dto.RespuestaGeneralDTO;
import com.gov.app.prueba.clteach.PacienteMS.entity.ExamenEntity;
import com.gov.app.prueba.clteach.PacienteMS.repository.ExamenRepository;
import com.gov.app.prueba.clteach.PacienteMS.repository.PacienteRepository;
import com.gov.app.prueba.clteach.PacienteMS.service.impl.ConsultarPacienteService;
import com.gov.app.prueba.clteach.PacienteMS.util.mappers.ExamenMapper;
import com.gov.app.prueba.clteach.PacienteMS.util.mappers.PacienteMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ConsultarPacienteServiceTest {

    @InjectMocks
    private ConsultarPacienteService consultarPacienteService;

    @Mock
    private ExamenRepository examenRepository;

    @Mock
    private PacienteRepository pacienteRepository;

    @Mock
    private PacienteMapper pacienteMapper;

    @Mock
    private ExamenMapper examenMapper;

    @Test
    void testConsultarPacientesSuccess() {
        // Arrange
        List<PacienteDTO> mockPacientes = List.of(
                PacienteDTO.builder()
                        .idPaciente(1L)
                        .nombrePaciente("Juan Pérez")
                        .numeroOrden("12345")
                        .build()
        );
        Object[] objetos = new Object[]{1L, "EX001", "Positivo"};
        List<Object[]> mockExamenEntities = new ArrayList<>();
        mockExamenEntities.add(objetos);
        List<ExamenDTO> mockExamenes = List.of(
                ExamenDTO.builder()
                        .idExamen(1L)
                        .codigoExamen("EX001")
                        .resultadoExamen("Positivo")
                        .build()
        );

        when(pacienteRepository.findAll()).thenReturn(List.of());
        when(pacienteMapper.listEntityToListDto(anyList())).thenReturn(mockPacientes);
        when(examenRepository.findAllPaciente(1L)).thenReturn(mockExamenEntities);
        when(examenMapper.listObjectToListDto(mockExamenEntities)).thenReturn(mockExamenes);

        // Act
        RespuestaGeneralDTO response = consultarPacienteService.consultarPacientes();

        // Assert
        assertEquals(HttpStatus.OK.name(), response.getStatus());
        assertEquals(HttpStatus.OK.value(), response.getCodigo());
        assertEquals("Se han consultado correctamente los pacientes", response.getMessage());
        assertEquals(1, ((List<?>) response.getData()).size());
        verify(pacienteRepository, times(1)).findAll();
        verify(pacienteMapper, times(1)).listEntityToListDto(anyList());
        verify(examenRepository, times(1)).findAllPaciente(1L);
        verify(examenMapper, times(1)).listObjectToListDto(mockExamenEntities);
    }

    @Test
    void testConsultarPacientesError() {
        // Arrange
        when(pacienteRepository.findAll()).thenThrow(new RuntimeException("Database error"));

        // Act
        RespuestaGeneralDTO response = consultarPacienteService.consultarPacientes();

        // Assert
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.name(), response.getStatus());
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), response.getCodigo());
        assertEquals("Hubo un error en la consulta de los pacientes", response.getMessage());
        assertEquals(null, response.getData());
        verify(pacienteRepository, times(1)).findAll();
        verifyNoInteractions(examenRepository);
        verifyNoInteractions(pacienteMapper);
        verifyNoInteractions(examenMapper);
    }
}
