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
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

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
    void testValidacionesPaciente_Success() throws Exception {
        // Arrange
        PacienteRequestDTO requestDTO = new PacienteRequestDTO("Juan Pérez", "12345", "EX001", "Positivo");
        PacienteDTO pacienteDTO = new PacienteDTO("Juan Pérez", 12345);
        ExamenDTO examenDTO = new ExamenDTO("EX001", "Positivo", null);
        PacienteEntity pacienteEntity = new PacienteEntity();
        ExamenEntity examenEntity = new ExamenEntity();

        when(pacienteMapper.dtoToEntity(pacienteDTO)).thenReturn(pacienteEntity);
        when(examenMapper.dtoToEntity(examenDTO)).thenReturn(examenEntity);
        when(pacienteRepository.save(any(PacienteEntity.class))).thenReturn(pacienteEntity);
        when(examenRepository.save(any(ExamenEntity.class))).thenReturn(examenEntity);

        // Act
        RespuestaGeneralDTO response = guardarPacienteService.validacionesPaciente(requestDTO);

        // Assert
        assertEquals(HttpStatus.CREATED.name(), response.getStatus());
        assertEquals(HttpStatus.CREATED.value(), response.getCodigo());
        assertEquals("El paciente y los exámenes se han guardado correctamente", response.getMessage());
        verify(pacienteMapper, times(1)).dtoToEntity(any(PacienteDTO.class));
        verify(examenMapper, times(1)).dtoToEntity(any(ExamenDTO.class));
        verify(pacienteRepository, times(1)).save(any(PacienteEntity.class));
        verify(examenRepository, times(1)).save(any(ExamenEntity.class));
    }

    @Test
    void testValidacionesPaciente_Error() throws Exception {
        // Arrange
        PacienteRequestDTO requestDTO = new PacienteRequestDTO("Juan Pérez", "12345", "EX001", "Positivo");
        PacienteDTO pacienteDTO = new PacienteDTO("Juan Pérez", 12345);
        ExamenDTO examenDTO = new ExamenDTO("EX001", "Positivo", null);

        when(pacienteMapper.dtoToEntity(pacienteDTO)).thenThrow(new RuntimeException("Database error"));

        // Act
        RespuestaGeneralDTO response = guardarPacienteService.validacionesPaciente(requestDTO);

        // Assert
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.name(), response.getStatus());
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), response.getCodigo());
        assertEquals("Error al guardar el paciente y los exámenes", response.getMessage());
        assertNull(response.getData());
        verify(pacienteMapper, times(1)).dtoToEntity(any(PacienteDTO.class));
        verifyNoInteractions(examenMapper);
        verifyNoInteractions(pacienteRepository);
        verifyNoInteractions(examenRepository);
    }
}
