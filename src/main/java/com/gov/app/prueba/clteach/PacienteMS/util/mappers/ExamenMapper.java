package com.gov.app.prueba.clteach.PacienteMS.util.mappers;

import com.gov.app.prueba.clteach.PacienteMS.dto.ExamenDTO;
import com.gov.app.prueba.clteach.PacienteMS.entity.ExamenEntity;
import com.gov.app.prueba.clteach.PacienteMS.util.helper.Utilidades;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Mapper para convertir entre objetos de tipo {@link ExamenEntity} y {@link ExamenDTO}.
 * <p>
 * Utiliza MapStruct para generar automáticamente las implementaciones de los métodos,
 * facilitando la conversión entre entidades de la base de datos y objetos de transferencia de datos (DTOs).
 * Adicionalmente, proporciona métodos personalizados para convertir listas de objetos genéricos a DTOs.
 * </p>
 */
@Mapper(componentModel = "spring")
public interface ExamenMapper {

    /**
     * Convierte una entidad de tipo {@link ExamenEntity} a un objeto de tipo {@link ExamenDTO}.
     *
     * @param entity La entidad de tipo {@link ExamenEntity} a convertir.
     * @return Un objeto de tipo {@link ExamenDTO}.
     */
    ExamenDTO entityToDto(ExamenEntity entity);

    /**
     * Convierte un objeto de tipo {@link ExamenDTO} a una entidad de tipo {@link ExamenEntity}.
     *
     * @param dto El objeto de tipo {@link ExamenDTO} a convertir.
     * @return Una entidad de tipo {@link ExamenEntity}.
     */
    ExamenEntity dtoToEntity(ExamenDTO dto);

    /**
     * Convierte una lista de entidades de tipo {@link ExamenEntity} a una lista de objetos de tipo {@link ExamenDTO}.
     *
     * @param entity La lista de entidades de tipo {@link ExamenEntity} a convertir.
     * @return Una lista de objetos de tipo {@link ExamenDTO}.
     */
    List<ExamenDTO> listEntityToListDto(List<ExamenEntity> entity);

    /**
     * Convierte una lista de objetos de tipo {@link ExamenDTO} a una lista de entidades de tipo {@link ExamenEntity}.
     *
     * @param dto La lista de objetos de tipo {@link ExamenDTO} a convertir.
     * @return Una lista de entidades de tipo {@link ExamenEntity}.
     */
    List<ExamenEntity> listDtoToListEntity(List<ExamenDTO> dto);

    /**
     * Convierte una lista de objetos genéricos (<code>Object[]</code>) a una lista de objetos de tipo {@link ExamenDTO}.
     * <p>
     * Este método permite procesar listas genéricas provenientes de consultas personalizadas,
     * extrayendo y transformando los valores en objetos DTO.
     * </p>
     *
     * @param listObj La lista de arreglos de objetos (<code>Object[]</code>) a convertir.
     * @return Una lista de objetos de tipo {@link ExamenDTO}.
     */
    default List<ExamenDTO> listObjectToListDto(List<Object[]> listObj) {
        List<ExamenDTO> listDto = new ArrayList<>();
        for (Object[] obj : listObj) {
            listDto.add(
                    ExamenDTO.builder()
                            .idExamen(Utilidades.checkType(obj[0], Long.class).orElse(null))
                            .codigoExamen(Utilidades.checkType(obj[1], String.class).orElse(null))
                            .resultadoExamen(Utilidades.checkType(obj[2], String.class).orElse(null))
                            .build()
            );
        }
        return listDto;
    }
}
