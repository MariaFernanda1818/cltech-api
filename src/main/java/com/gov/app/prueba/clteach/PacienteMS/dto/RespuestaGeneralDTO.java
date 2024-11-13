package com.gov.app.prueba.clteach.PacienteMS.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RespuestaGeneralDTO implements Serializable {

    private HttpStatus status;

    private Object data;

    private String message;
}
