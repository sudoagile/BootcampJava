package com.codigo.ramirezdelama.infraestructure.mapper;

import com.codigo.ramirezdelama.domain.aggregates.dto.EmpresaDTO;
import com.codigo.ramirezdelama.infraestructure.entity.EmpresaEntity;

public class EmpresaMapper {
    public static EmpresaDTO fromEntity(EmpresaEntity entity) {
        EmpresaDTO dto = new EmpresaDTO();

        dto.setId(entity.getId());
        dto.setRazonSocial(entity.getRazonSocial());
        dto.setTipoDoc(entity.getTipoDocumento());
        dto.setNumDoc(entity.getNumeroDocumento());
        dto.setEstado(entity.getEstado());
        dto.setCondicion(entity.getCondicion());
        dto.setDireccion(entity.getDireccion());
        dto.setDistrito(entity.getDistrito());
        dto.setProvincia(entity.getProvincia());
        dto.setDepartamento(entity.getDepartamento());
        dto.setEsAgenteRetencion(entity.isEsAgenteRetencion());
        dto.setUsuaCrea(entity.getUsuaCrea());
        dto.setDateCreate(entity.getDateCreate());
        dto.setUsuaModif(entity.getUsuaModif());
        dto.setDateModif(entity.getDateModif());
        dto.setUsuaDelet(entity.getUsuaDelet());
        dto.setDateDelet(entity.getDateDelet());

        return dto;
    }
}