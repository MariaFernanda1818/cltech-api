package com.gov.app.prueba.clteach.PacienteMS.util.mappers;

import com.gov.app.prueba.clteach.PacienteMS.dto.ExamenDTO;
import com.gov.app.prueba.clteach.PacienteMS.entity.ExamenEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ExamenMapper {

    ExamenDTO entityToDto(ExamenEntity entity);

    ExamenEntity dtoToEntity(ExamenDTO dto);

    List<ExamenDTO> listEntityToListDto(List<ExamenEntity> entity);

    List<ExamenEntity> listDtoToListEntity(List<ExamenDTO> dto);
}
