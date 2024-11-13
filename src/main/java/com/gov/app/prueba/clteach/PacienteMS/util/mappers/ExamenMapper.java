package com.gov.app.prueba.clteach.PacienteMS.util.mappers;

import com.gov.app.prueba.clteach.PacienteMS.dto.ExamenDTO;
import com.gov.app.prueba.clteach.PacienteMS.entity.ExamenEntity;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * Mapper para convertir entre objetos de tipo {@link ExamenEntity} y {@link ExamenDTO}.
 * <p>
 * Utiliza MapStruct para generar automáticamente las implementaciones de los métodos,
 * facilitando la conversión entre entidades de la base de datos y objetos de transferencia de datos (DTOs).
 * </p>
 */
@Mapper(componentModel = "spring")
public interface ExamenMapper {

    /**
     * Convierte una entidad de tipo {@link ExamenEntity} a un objeto de tipo {@link ExamenDTO}.
     *
     * @param entity la entidad de tipo {@link ExamenEntity} a convertir.
     * @return un objeto de tipo {@link ExamenDTO}.
     */
    ExamenDTO entityToDto(ExamenEntity entity);

    /**
     * Convierte un objeto de tipo {@link ExamenDTO} a una entidad de tipo {@link ExamenEntity}.
     *
     * @param dto el objeto de tipo {@link ExamenDTO} a convertir.
     * @return una entidad de tipo {@link ExamenEntity}.
     */
    ExamenEntity dtoToEntity(ExamenDTO dto);

    /**
     * Convierte una lista de entidades de tipo {@link ExamenEntity} a una lista de objetos de tipo {@link ExamenDTO}.
     *
     * @param entity la lista de entidades de tipo {@link ExamenEntity} a convertir.
     * @return una lista de objetos de tipo {@link ExamenDTO}.
     */
    List<ExamenDTO> listEntityToListDto(List<ExamenEntity> entity);

    /**
     * Convierte una lista de objetos de tipo {@link ExamenDTO} a una lista de entidades de tipo {@link ExamenEntity}.
     *
     * @param dto la lista de objetos de tipo {@link ExamenDTO} a convertir.
     * @return una lista de entidades de tipo {@link ExamenEntity}.
     */
    List<ExamenEntity> listDtoToListEntity(List<ExamenDTO> dto);
}
