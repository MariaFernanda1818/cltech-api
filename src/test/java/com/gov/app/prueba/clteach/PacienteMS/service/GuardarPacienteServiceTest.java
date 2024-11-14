package com.gov.app.prueba.clteach.PacienteMS.service;

import com.gov.app.prueba.clteach.PacienteMS.dto.*;
import com.gov.app.prueba.clteach.PacienteMS.entity.ExamenEntity;
import com.gov.app.prueba.clteach.PacienteMS.entity.PacienteEntity;
import com.gov.app.prueba.clteach.PacienteMS.repository.ExamenRepository;
import com.gov.app.prueba.clteach.PacienteMS.repository.PacienteRepository;
import com.gov.app.prueba.clteach.PacienteMS.service.impl.GuardarPacienteService;
import com.gov.app.prueba.clteach.PacienteMS.util.mappers.ExamenMapper;
import com.gov.app.prueba.clteach.PacienteMS.util.mappers.PacienteMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GuardarPacienteServiceTest {

    @InjectMocks
    private GuardarPacienteService guardarPacienteService;

    @Mock
    private PacienteMapper pacienteMapper;

    @Mock
    private ExamenMapper examenMapper;

    @Mock
    private PacienteRepository pacienteRepository;

    @Mock
    private ExamenRepository examenRepository;

    @Test
    void testValidacionesPacienteSuccess() throws Exception {
        // Arrange
        PacienteRequestDTO requestDTO = new PacienteRequestDTO();
        requestDTO.setNombres("Juan Pérez");
        requestDTO.setNumeroOrden("12345");
        requestDTO.setExamenes(List.of(
                ExamenDTO.builder().codigoExamen("EX001").resultadoExamen("Positivo").build()
        ));

        PacienteDTO pacienteDTO = PacienteDTO.builder()
                .nombrePaciente("Juan Pérez")
                .numeroOrden("12345")
                .build();
        PacienteEntity pacienteEntity = new PacienteEntity();
        ExamenEntity examenEntity = new ExamenEntity();

        when(pacienteRepository.existsByNumeroOrden("12345")).thenReturn(false);
        when(pacienteMapper.dtoToEntity(pacienteDTO)).thenReturn(pacienteEntity);
        when(pacienteRepository.save(any(PacienteEntity.class))).thenReturn(pacienteEntity);
        when(examenMapper.dtoToEntity(any(ExamenDTO.class))).thenReturn(examenEntity);
        when(examenRepository.save(any(ExamenEntity.class))).thenReturn(examenEntity);

        // Act
        RespuestaGeneralDTO response = guardarPacienteService.validacionesPaciente(requestDTO);

        // Assert
        assertEquals(HttpStatus.CREATED.name(), response.getStatus());
        assertEquals(HttpStatus.CREATED.value(), response.getCodigo());
        assertEquals("El paciente y los exámenes se han guardado correctamente", response.getMessage());
        verify(pacienteRepository, times(1)).existsByNumeroOrden("12345");
        verify(pacienteMapper, times(1)).dtoToEntity(any(PacienteDTO.class));
        verify(pacienteRepository, times(1)).save(any(PacienteEntity.class));
        verify(examenMapper, times(1)).dtoToEntity(any(ExamenDTO.class));
        verify(examenRepository, times(1)).save(any(ExamenEntity.class));
    }

    @Test
    void testValidacionesPacienteNumeroOrdenDuplicado() throws Exception {
        // Arrange
        PacienteRequestDTO requestDTO = new PacienteRequestDTO();
        requestDTO.setNombres("Juan Pérez");
        requestDTO.setNumeroOrden("12345");

        when(pacienteRepository.existsByNumeroOrden("12345")).thenReturn(true);

        // Act
        RespuestaGeneralDTO response = guardarPacienteService.validacionesPaciente(requestDTO);

        // Assert
        assertEquals(HttpStatus.BAD_REQUEST.name(), response.getStatus());
        assertEquals(HttpStatus.OK.value(), response.getCodigo());
        assertEquals("El numero de orden del paciente ya fue registrado", response.getMessage());
        verify(pacienteRepository, times(1)).existsByNumeroOrden("12345");
        verifyNoInteractions(pacienteMapper);
        verifyNoInteractions(examenMapper);
        verifyNoInteractions(examenRepository);
    }

    @Test
    void testValidacionesPaciente_Error() throws Exception {
        // Arrange
        PacienteRequestDTO requestDTO = new PacienteRequestDTO();
        requestDTO.setNombres("Juan Pérez");
        requestDTO.setNumeroOrden("12345");
        requestDTO.setExamenes(List.of(
                ExamenDTO.builder().codigoExamen("EX001").resultadoExamen("Positivo").build()
        ));

        PacienteDTO pacienteDTO = PacienteDTO.builder()
                .nombrePaciente("Juan Pérez")
                .numeroOrden("12345")
                .build();
        PacienteEntity pacienteEntity = new PacienteEntity();

        when(pacienteRepository.existsByNumeroOrden("12345")).thenReturn(false);
        when(pacienteMapper.dtoToEntity(pacienteDTO)).thenThrow(new RuntimeException("Database error"));

        // Act
        RespuestaGeneralDTO response = guardarPacienteService.validacionesPaciente(requestDTO);

        // Assert
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.name(), response.getStatus());
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), response.getCodigo());
        assertEquals("Error al guardar el paciente y los exámenes", response.getMessage());
        verify(pacienteRepository, times(1)).existsByNumeroOrden("12345");
        verify(pacienteMapper, times(1)).dtoToEntity(any(PacienteDTO.class));
        verifyNoInteractions(examenMapper);
        verifyNoInteractions(examenRepository);
    }
}
