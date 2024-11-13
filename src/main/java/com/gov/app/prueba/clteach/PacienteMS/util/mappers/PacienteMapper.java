package com.gov.app.prueba.clteach.PacienteMS.util.mappers;

import com.gov.app.prueba.clteach.PacienteMS.dto.PacienteDTO;
import com.gov.app.prueba.clteach.PacienteMS.entity.PacienteEntity;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * Mapper para convertir entre objetos de tipo {@link PacienteEntity} y {@link PacienteDTO}.
 * <p>
 * Utiliza MapStruct para realizar las conversiones automáticamente. Este mapper
 * es un componente gestionado por Spring, configurado con {@code componentModel = "spring"}.
 * </p>
 */
@Mapper(componentModel = "spring")
public interface PacienteMapper {

    /**
     * Convierte una entidad de tipo {@link PacienteEntity} a un objeto de tipo {@link PacienteDTO}.
     *
     * @param entity la entidad de paciente a convertir.
     * @return un objeto {@link PacienteDTO} que representa los datos de la entidad.
     */
    PacienteDTO entityToDto(PacienteEntity entity);

    /**
     * Convierte un objeto de tipo {@link PacienteDTO} a una entidad de tipo {@link PacienteEntity}.
     *
     * @param dto el DTO de paciente a convertir.
     * @return una entidad {@link PacienteEntity} que representa los datos del DTO.
     */
    PacienteEntity dtoToEntity(PacienteDTO dto);

    /**
     * Convierte una lista de entidades de tipo {@link PacienteEntity} a una lista de objetos {@link PacienteDTO}.
     *
     * @param entity una lista de entidades de paciente a convertir.
     * @return una lista de objetos {@link PacienteDTO} que representan los datos de las entidades.
     */
    List<PacienteDTO> listEntityToListDto(List<PacienteEntity> entity);

    /**
     * Convierte una lista de objetos de tipo {@link PacienteDTO} a una lista de entidades {@link PacienteEntity}.
     *
     * @param dto una lista de DTOs de paciente a convertir.
     * @return una lista de entidades {@link PacienteEntity} que representan los datos de los DTOs.
     */
    List<PacienteEntity> listDtoToListEntity(List<PacienteDTO> dto);
}
