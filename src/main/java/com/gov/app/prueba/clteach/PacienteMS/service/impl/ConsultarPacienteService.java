package com.gov.app.prueba.clteach.PacienteMS.service.impl;

import com.gov.app.prueba.clteach.PacienteMS.dto.RespuestaGeneralDTO;
import com.gov.app.prueba.clteach.PacienteMS.repository.ExamenRepository;
import com.gov.app.prueba.clteach.PacienteMS.service.IConsultarPacienteService;
import com.gov.app.prueba.clteach.PacienteMS.util.mappers.ExamenMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 * Servicio para consultar los pacientes y sus exámenes registrados en el sistema.
 * <p>
 * Implementa la interfaz {@link IConsultarPacienteService} y utiliza el repositorio {@link ExamenRepository}
 * para acceder a los datos almacenados. Los datos recuperados son transformados utilizando {@link ExamenMapper}
 * antes de enviarlos en la respuesta.
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
     * Mapper para convertir entidades de exámenes a DTOs.
     */
    private final ExamenMapper examenMapper;

    /**
     * Consulta todos los pacientes y sus exámenes registrados.
     * <p>
     * Recupera los datos de los exámenes desde el repositorio y los transforma en una lista de DTOs
     * utilizando el mapper. En caso de éxito, devuelve una respuesta con los datos y un mensaje.
     * Si ocurre un error, devuelve un mensaje descriptivo con el estado correspondiente.
     * </p>
     *
     * @return un objeto {@link RespuestaGeneralDTO} que contiene los datos de los pacientes y el estado de la operación.
     */
    @Override
    public RespuestaGeneralDTO consultarPacientes() {
        RespuestaGeneralDTO respuesta = new RespuestaGeneralDTO();
        try {
            respuesta.setData(examenMapper.listEntityToListDto(examenRepository.findAll()));
            respuesta.setMessage("Se han consultado correctamente los pacientes");
            respuesta.setStatus(HttpStatus.OK.name());
            respuesta.setCodigo(HttpStatus.OK.value());
        } catch (Exception ex) {
            log.error("Error al consultar los pacientes", ex);
            respuesta.setMessage("Hubo un error en la consulta de los pacientes");
            respuesta.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.name());
            respuesta.setCodigo(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
        return respuesta;
    }
}
