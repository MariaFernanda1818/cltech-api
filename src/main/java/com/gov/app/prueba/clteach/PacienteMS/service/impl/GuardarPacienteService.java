package com.gov.app.prueba.clteach.PacienteMS.service.impl;

import com.gov.app.prueba.clteach.PacienteMS.dto.*;
import com.gov.app.prueba.clteach.PacienteMS.entity.ExamenEntity;
import com.gov.app.prueba.clteach.PacienteMS.entity.PacienteEntity;
import com.gov.app.prueba.clteach.PacienteMS.repository.ExamenRepository;
import com.gov.app.prueba.clteach.PacienteMS.repository.PacienteRepository;
import com.gov.app.prueba.clteach.PacienteMS.service.IGuardarPacienteService;
import com.gov.app.prueba.clteach.PacienteMS.util.mappers.ExamenMapper;
import com.gov.app.prueba.clteach.PacienteMS.util.mappers.PacienteMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.gov.app.prueba.clteach.PacienteMS.util.helper.Constantes.*;

/**
 * Servicio para realizar la validación y el guardado de pacientes y sus exámenes.
 * <p>
 * Implementa la interfaz {@link IGuardarPacienteService} y gestiona la lógica necesaria
 * para validar los datos de un paciente y sus exámenes, además de almacenarlos en la base de datos.
 * </p>
 */
@Service
@RequiredArgsConstructor
public class GuardarPacienteService implements IGuardarPacienteService {

    /**
     * Mapper para convertir entre {@link PacienteDTO} y {@link PacienteEntity}.
     */
    private final PacienteMapper pacienteMapper;

    /**
     * Mapper para convertir entre {@link ExamenDTO} y {@link ExamenEntity}.
     */
    private final ExamenMapper examenMapper;

    /**
     * Repositorio para realizar operaciones CRUD sobre la entidad {@link PacienteEntity}.
     */
    private final PacienteRepository pacienteRepository;

    /**
     * Repositorio para realizar operaciones CRUD sobre la entidad {@link ExamenEntity}.
     */
    private final ExamenRepository examenRepository;

    /**
     * Valida los datos del paciente y sus exámenes, y los guarda en la base de datos.
     * <p>
     * Este método realiza las siguientes operaciones:
     * <ul>
     *     <li>Convierte el DTO de paciente y examen a sus respectivas entidades.</li>
     *     <li>Guarda los datos del paciente y asocia los exámenes al paciente guardado.</li>
     *     <li>Gestiona transacciones para garantizar la consistencia de los datos.</li>
     * </ul>
     * En caso de éxito, devuelve un objeto {@link RespuestaGeneralDTO} con el estado "CREATED".
     * Si ocurre un error, devuelve un estado de error y un mensaje descriptivo.
     * </p>
     *
     * @param pacienteRequestDTO objeto que contiene los datos del paciente y sus exámenes.
     * @return un objeto {@link RespuestaGeneralDTO} con el estado de la operación.
     * @throws Exception si ocurre algún error durante el proceso de validación o guardado.
     */
    @Override
    @Transactional
    public RespuestaGeneralDTO validacionesPaciente(PacienteRequestDTO pacienteRequestDTO) throws Exception {

        RespuestaGeneralDTO respuestaGeneralDTO = new RespuestaGeneralDTO();
        if(pacienteRepository.existsByNumeroOrden(pacienteRequestDTO.getNumeroOrden())) {
            respuestaGeneralDTO.setStatus(HttpStatus.BAD_REQUEST.name());
            respuestaGeneralDTO.setCodigo(HttpStatus.OK.value());
            respuestaGeneralDTO.setMessage(NUMERO_ORDEN_REGISTRADO);
            return respuestaGeneralDTO;
        }
        try {
            PacienteDTO pacienteDTO = PacienteDTO.builder()
                    .nombrePaciente(pacienteRequestDTO.getNombres())
                    .numeroOrden(pacienteRequestDTO.getNumeroOrden())
                    .build();
            // Convertir DTOs a entidades
            PacienteEntity pacienteEntity = pacienteMapper.dtoToEntity(pacienteDTO);
            pacienteEntity = pacienteRepository.save(pacienteEntity);
            for(ExamenDTO examen :  pacienteRequestDTO.getExamenes()){
                ExamenEntity examenEntity = examenMapper.dtoToEntity(examen);
                examenEntity.setPacienteFk(pacienteEntity);
                examenRepository.save(examenEntity);
            }
            // Configurar respuesta de éxito
            respuestaGeneralDTO.setStatus(HttpStatus.CREATED.name());
            respuestaGeneralDTO.setCodigo(HttpStatus.CREATED.value());
            respuestaGeneralDTO.setMessage(PACIENTE_EXAMENES_GUARDADOS);

        } catch (Exception e) {
            // Configurar respuesta de error
            respuestaGeneralDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.name());
            respuestaGeneralDTO.setCodigo(HttpStatus.INTERNAL_SERVER_ERROR.value());
            respuestaGeneralDTO.setMessage(ERRROR_GUARDADO_PACIENTE_EXAMENES);
        }
        return respuestaGeneralDTO;
    }
}
