package com.codigo.ramirezdelama.domain.aggregates.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter

public class EmpresaDTO {
   private Long id;
   private String razonSocial;
   private String tipoDoc;
   private String numDoc;
   private int estado;
   private String condicion;
   private String direccion;
   private String distrito;
   private String provincia;
   private String departamento;
   private boolean esAgenteRetencion;
   private String usuaCrea;
   private Timestamp dateCreate;
   private String usuaModif;
   private Timestamp dateModif;
   private String usuaDelet;
   private Timestamp dateDelet;
}
