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

@Service
@RequiredArgsConstructor
public class GuardarPacienteService implements IGuardarPacienteService {

    private final PacienteMapper pacienteMapper;

    private final ExamenMapper examenMapper;

    private final PacienteRepository pacienteRepository;

    private final ExamenRepository examenRepository;


    @Override
    @Transactional
    public RespuestaGeneralDTO validacionesPaciente(PacienteRequestDTO pacienteRequestDTO) throws Exception {

        RespuestaGeneralDTO respuestaGeneralDTO = new RespuestaGeneralDTO();

        PacienteDTO pacienteDTO = PacienteDTO.builder().nombrePaciente(pacienteRequestDTO.getNombres()).numeroOrden(Integer.valueOf(pacienteRequestDTO.getNumeroOrden())).build();
        ExamenDTO examenDTO = ExamenDTO.builder().codigoExamen(pacienteRequestDTO.getCodigoExamen()).resultadoExamen(pacienteRequestDTO.getResultadoExamen()).build();
        try {
            PacienteEntity pacienteEntity = pacienteMapper.dtoToEntity(pacienteDTO);
            ExamenEntity examenEntity = examenMapper.dtoToEntity(examenDTO);

            pacienteEntity = pacienteRepository.save(pacienteEntity);
            examenEntity.setPacienteFk(pacienteEntity);
            examenEntity = examenRepository.save(examenEntity);

            respuestaGeneralDTO.setStatus(HttpStatus.CREATED);
            respuestaGeneralDTO.setData(examenMapper.entityToDto(examenEntity));
            respuestaGeneralDTO.setMessage("El paciente y los examenes se han guardado correctamente ");

        } catch (Exception e) {
            respuestaGeneralDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            respuestaGeneralDTO.setData(null);
            respuestaGeneralDTO.setMessage("Error al guardar el paciente y los examenes");
        }
        return respuestaGeneralDTO;
    }

}
