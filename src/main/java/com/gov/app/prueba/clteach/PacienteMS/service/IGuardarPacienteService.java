package com.gov.app.prueba.clteach.PacienteMS.service;

import com.gov.app.prueba.clteach.PacienteMS.dto.PacienteDTO;
import com.gov.app.prueba.clteach.PacienteMS.dto.PacienteRequestDTO;
import com.gov.app.prueba.clteach.PacienteMS.dto.RespuestaGeneralDTO;

/**
 * Interfaz para el servicio de guardado de pacientes.
 * <p>
 * Proporciona la definición de un método para realizar validaciones y guardar
 * la información de un paciente y sus exámenes en el sistema.
 * Las implementaciones deben manejar la lógica necesaria para validar los datos
 * y persistirlos en la base de datos.
 * </p>
 */
public interface IGuardarPacienteService {

    /**
     * Realiza las validaciones necesarias y guarda la información del paciente y sus exámenes.
     * <p>
     * Este método valida los datos contenidos en el objeto {@link PacienteRequestDTO},
     * realiza las conversiones requeridas a entidades, y los guarda en la base de datos.
     * En caso de éxito, devuelve un objeto {@link RespuestaGeneralDTO} con el estado
     * y mensaje de la operación.
     * </p>
     *
     * @param pacienteRequestDTO el objeto que contiene los datos del paciente y sus exámenes.
     * @return un objeto {@link RespuestaGeneralDTO} con el estado y resultado de la operación.
     * @throws Exception si ocurre algún error durante el proceso de validación o guardado.
     */
    RespuestaGeneralDTO validacionesPaciente(PacienteRequestDTO pacienteRequestDTO) throws Exception;
}
