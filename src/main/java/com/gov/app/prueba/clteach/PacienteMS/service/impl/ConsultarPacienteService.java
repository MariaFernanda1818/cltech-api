package com.gov.app.prueba.clteach.PacienteMS.service.impl;

import com.gov.app.prueba.clteach.PacienteMS.dto.ExamenDTO;
import com.gov.app.prueba.clteach.PacienteMS.dto.PacienteDTO;
import com.gov.app.prueba.clteach.PacienteMS.dto.PacienteRespuestaDTO;
import com.gov.app.prueba.clteach.PacienteMS.dto.RespuestaGeneralDTO;
import com.gov.app.prueba.clteach.PacienteMS.repository.ExamenRepository;
import com.gov.app.prueba.clteach.PacienteMS.repository.PacienteRepository;
import com.gov.app.prueba.clteach.PacienteMS.service.IConsultarPacienteService;
import com.gov.app.prueba.clteach.PacienteMS.util.mappers.ExamenMapper;
import com.gov.app.prueba.clteach.PacienteMS.util.mappers.PacienteMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.gov.app.prueba.clteach.PacienteMS.util.helper.Constantes.*;

/**
 * Servicio para consultar los pacientes y sus exámenes registrados en el sistema.
 * <p>
 * Esta clase implementa la interfaz {@link IConsultarPacienteService} para proporcionar
 * operaciones de consulta relacionadas con pacientes y sus exámenes. Utiliza los repositorios
 * {@link PacienteRepository} y {@link ExamenRepository} para acceder a los datos almacenados,
 * y los mappers {@link PacienteMapper} y {@link ExamenMapper} para transformar las entidades
 * a objetos DTO.
 * </p>
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class ConsultarPacienteService implements IConsultarPacienteService {

    /**
     * Repositorio para acceder a los datos de los exámenes.
     */
    private final ExamenRepository examenRepository;

    /**
     * Repositorio para acceder a los datos de los pacientes.
     */
    private final PacienteRepository pacienteRepository;

    /**
     * Mapper para transformar entidades de pacientes a DTOs.
     */
    private final PacienteMapper pacienteMapper;

    /**
     * Mapper para transformar entidades de exámenes a DTOs.
     */
    private final ExamenMapper examenMapper;

    /**
     * Consulta todos los pacientes y sus exámenes registrados.
     * <p>
     * Recupera todos los pacientes registrados en el sistema junto con los exámenes asociados.
     * Los datos son transformados a DTOs y se encapsulan en una lista que se incluye en la respuesta.
     * En caso de error, devuelve un mensaje descriptivo y el estado de la operación.
     * </p>
     *
     * @return Un objeto {@link RespuestaGeneralDTO} que contiene los datos de los pacientes con sus exámenes
     * y el estado de la operación.
     */
    @Override
    public RespuestaGeneralDTO consultarPacientes() {
        RespuestaGeneralDTO respuesta = new RespuestaGeneralDTO();
        List<PacienteRespuestaDTO> respuestaData = new ArrayList<>();
        try {
            // Consultar pacientes y convertir a DTOs
            List<PacienteDTO> pacientes = pacienteMapper.listEntityToListDto(pacienteRepository.findAll());
            for (PacienteDTO paciente : pacientes) {
                // Consultar exámenes asociados y convertir a DTOs
                List<ExamenDTO> examenes = examenMapper.listObjectToListDto(
                        examenRepository.findAllPaciente(paciente.getIdPaciente())
                );
                // Construir la respuesta para cada paciente
                respuestaData.add(PacienteRespuestaDTO.builder()
                        .idPaciente(paciente.getIdPaciente())
                        .nombrePaciente(paciente.getNombrePaciente())
                        .numeroOrden(paciente.getNumeroOrden())
                        .examenes(examenes)
                        .build());
            }
            // Configurar la respuesta de éxito
            respuesta.setData(respuestaData);
            respuesta.setMessage(CONSULTA_CORRECTAMENTE);
            respuesta.setStatus(HttpStatus.OK.name());
            respuesta.setCodigo(HttpStatus.OK.value());
        } catch (Exception ex) {
            // Manejo de errores y configuración de la respuesta
            log.error(ERROR_CONSULTA, ex);
            respuesta.setMessage(ERROR_CONSULTA_MENSAJE);
            respuesta.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.name());
            respuesta.setCodigo(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
        return respuesta;
    }
}
