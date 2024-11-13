package com.gov.app.prueba.clteach.PacienteMS.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class PacienteRequestDTO {

    @NotNull
    @NotBlank
    private String nombres;

    @NotBlank
    @NotBlank
    private String numeroOrden;

    @NotBlank
    @NotBlank
    private String codigoExamen;

    @NotBlank
    @NotBlank
    private String resultadoExamen;

}
