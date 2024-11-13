package com.gov.app.prueba.clteach.PacienteMS.service.impl;

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

@Service
@RequiredArgsConstructor
@Slf4j
public class ConsultarPacienteService implements IConsultarPacienteService {
    
   private final ExamenRepository examenRepository;

   private final ExamenMapper examenMapper;

    @Override
    public RespuestaGeneralDTO consultarPacientes(){
        RespuestaGeneralDTO respuesta = new RespuestaGeneralDTO();
        try{
            respuesta.setData(examenMapper.listEntityToListDto(examenRepository.findAll()));
            respuesta.setMessage("Se han consultado correctamente los pacientes");
            respuesta.setStatus(HttpStatus.OK);
        }catch (Exception ex){
            log.error("Error al consultar los pacientes", ex);
            respuesta.setMessage("Hubo un error en la consulta de los pacientes");
            respuesta.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return respuesta;
    }
    
}
