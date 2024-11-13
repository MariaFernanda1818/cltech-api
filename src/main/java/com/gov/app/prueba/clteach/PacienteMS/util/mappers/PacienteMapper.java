package com.gov.app.prueba.clteach.PacienteMS.util.mappers;

import com.gov.app.prueba.clteach.PacienteMS.dto.PacienteDTO;
import com.gov.app.prueba.clteach.PacienteMS.entity.PacienteEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PacienteMapper {

    PacienteDTO entityToDto(PacienteEntity entity);

    PacienteEntity dtoToEntity(PacienteDTO dto);

    List<PacienteDTO> listEntityToListDto(List<PacienteEntity> entity);

    List<PacienteEntity> listDtoToListEntity(List<PacienteDTO> dto);

}
