package com.gov.app.prueba.clteach.PacienteMS.service;

import com.gov.app.prueba.clteach.PacienteMS.dto.RespuestaGeneralDTO;

/**
 * Interfaz para el servicio de consulta de pacientes.
 * <p>
 * Proporciona la definición de un método para consultar los pacientes registrados en el sistema.
 * La implementación de esta interfaz debe manejar la lógica necesaria para recuperar
 * y estructurar los datos de los pacientes.
 * </p>
 */
public interface IConsultarPacienteService {

    /**
     * Consulta todos los pacientes registrados en el sistema.
     * <p>
     * Este método debe devolver una respuesta estructurada que incluya
     * los datos de los pacientes y el estado de la operación.
     * </p>
     *
     * @return un objeto {@link RespuestaGeneralDTO} que contiene los datos de los pacientes
     * y el estado de la operación.
     */
    RespuestaGeneralDTO consultarPacientes();
}
