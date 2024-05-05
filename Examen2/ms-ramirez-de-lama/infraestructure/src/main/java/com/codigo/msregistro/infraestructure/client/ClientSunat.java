package com.codigo.msregistro.infraestructure.client;

import com.codigo.msregistro.domain.aggregates.dto.EmpresaDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "client-sunat", url = "https://api.apis.net.pe/v2/sunat/")
public interface ClientSunat {

    @GetMapping("/ruc")
    EmpresaDTO getInfoSunat(@RequestParam("numero") String numero);
}
