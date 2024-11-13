package com.gov.app.prueba.clteach.PacienteMS.service;

import com.gov.app.prueba.clteach.PacienteMS.dto.ExamenDTO;
import com.gov.app.prueba.clteach.PacienteMS.dto.RespuestaGeneralDTO;
import com.gov.app.prueba.clteach.PacienteMS.entity.ExamenEntity;
import com.gov.app.prueba.clteach.PacienteMS.repository.ExamenRepository;
import com.gov.app.prueba.clteach.PacienteMS.service.impl.ConsultarPacienteService;
import com.gov.app.prueba.clteach.PacienteMS.util.mappers.ExamenMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

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
    private ExamenMapper examenMapper;

    @Test
    void testConsultarPacientes_Success() {
        // Arrange
        List<ExamenEntity> mockEntityList = List.of(new ExamenEntity());
        List<ExamenDTO> mockDtoList = List.of(new ExamenDTO());

        when(examenRepository.findAll()).thenReturn(mockEntityList);
        when(examenMapper.listEntityToListDto(mockEntityList)).thenReturn(mockDtoList);

        // Act
        RespuestaGeneralDTO response = consultarPacienteService.consultarPacientes();

        // Assert
        assertEquals(HttpStatus.OK.name(), response.getStatus());
        assertEquals(HttpStatus.OK.value(), response.getCodigo());
        assertEquals("Se han consultado correctamente los pacientes", response.getMessage());
        assertEquals(mockDtoList, response.getData());
        verify(examenRepository, times(1)).findAll();
        verify(examenMapper, times(1)).listEntityToListDto(mockEntityList);
    }

    @Test
    void testConsultarPacientes_Error() {
        // Arrange
        when(examenRepository.findAll()).thenThrow(new RuntimeException("Database error"));

        // Act
        RespuestaGeneralDTO response = consultarPacienteService.consultarPacientes();

        // Assert
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.name(), response.getStatus());
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), response.getCodigo());
        assertEquals("Hubo un error en la consulta de los pacientes", response.getMessage());
        assertEquals(null, response.getData());
        verify(examenRepository, times(1)).findAll();
        verifyNoInteractions(examenMapper);
    }
}
