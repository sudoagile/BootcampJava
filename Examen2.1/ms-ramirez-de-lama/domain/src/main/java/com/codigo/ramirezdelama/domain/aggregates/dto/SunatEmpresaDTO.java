package com.codigo.ramirezdelama.domain.aggregates.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class SunatEmpresaDTO {
    private String razonSocial;
    private String tipoDocumento;
    private String numeroDocumento;
    private String estado;
    private String condicion;
    private String direccion;
    private String ubigeo;
    private String viaTipo;
    private String viaNombre;
    private String zonaCodigo;
    private String zonaTipo;
    private int numero;
    private String interior;
    private String lote;
    private String dpto;
    private String manzana;
    private String kilimetro;
    private String distrito;
    private String provincia;
    private String departamento;
    private boolean esAgenteRetencion;

}
