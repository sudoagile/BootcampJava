package com.codigo.msregistro.domain.aggregates.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ReniecDTO {
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String tipoDocumento;
    private String numeroDocumento;
    private String digitoVerificador;
}
