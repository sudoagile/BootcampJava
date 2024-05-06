package com.codigo.ramirezdelama.infraestructure.adapters;

import com.codigo.ramirezdelama.domain.aggregates.constants.Constant;
import com.codigo.ramirezdelama.domain.aggregates.dto.PersonaDTO;
import com.codigo.ramirezdelama.domain.aggregates.dto.ReniecPersonaDTO;
import com.codigo.ramirezdelama.domain.aggregates.request.PersonaRequest;
import com.codigo.ramirezdelama.domain.port.out.PersonaServiceOut;
import com.codigo.ramirezdelama.infraestructure.client.ClientePersonaReniec;
import com.codigo.ramirezdelama.infraestructure.dao.EmpresaRepository;
import com.codigo.ramirezdelama.infraestructure.dao.PersonaRepository;
import com.codigo.ramirezdelama.infraestructure.entity.EmpresaEntity;
import com.codigo.ramirezdelama.infraestructure.entity.PersonaEntity;
import com.codigo.ramirezdelama.infraestructure.mapper.PersonaMapper;
import com.codigo.ramirezdelama.infraestructure.redis.RedisService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonaAdapter implements PersonaServiceOut {

    private final PersonaRepository personaRepository;
    private final ClientePersonaReniec clientePersonaReniec;
    private final RedisService redisService;
    private final EmpresaRepository empresaRepository;
    @Value("${token.api}")
    private String tokenReniec;

    private PersonaEntity getEntity(PersonaRequest personaRequest, boolean actualiza, Long id) {
        ReniecPersonaDTO reniecPersonaDTO = getExecReniec(personaRequest.getNumDoc());
        PersonaEntity entity = new PersonaEntity();
        entity.setNombre(reniecPersonaDTO.getNombres());
        entity.setNumeroDoc(reniecPersonaDTO.getNumeroDocumento());
        entity.setApeMat(reniecPersonaDTO.getApellidoMaterno());
        entity.setApePat(reniecPersonaDTO.getApellidoPaterno());
        entity.setTipoDoc(personaRequest.getTipoDoc());
        Optional<EmpresaEntity> empresaEntityOptional = empresaRepository.findByNumeroDocumento(personaRequest.getEmpresa());
        if(empresaEntityOptional.isPresent())
        {
            EmpresaEntity empresa = empresaEntityOptional.get();
            entity.setEmpresa(empresa);
            if(actualiza)
            {
                entity.setId(id);
                entity.setDateModif(getTimestamp());
                entity.setUsuaCrea(Constant.USU_ADMIN);
            }
            else {
                entity.setDateCreate(getTimestamp());
                entity.setUsuaCrea(Constant.USU_ADMIN);
            }
        }
        return entity;
    }

    private ReniecPersonaDTO getExecReniec(String numDoc) {
        String authorization = "Bearer " + tokenReniec;
        return clientePersonaReniec.getInfoReniec(numDoc, authorization);
    }

    private Timestamp getTimestamp() {
        long currentTime = System.currentTimeMillis();
        return new Timestamp(currentTime);
    }

    @Override
    public PersonaDTO createPersonaOut(PersonaRequest personaRequest) {
        PersonaEntity personaEntity = getEntity(personaRequest, false, null);
        if(personaEntity.getEmpresa() != null)
        {
            PersonaEntity personaSaved = personaRepository.save(personaEntity);
            return PersonaMapper.fromEntity(personaSaved);
        }
        else {
            return null;
        }
    }
    @Override
    public Optional<PersonaDTO> findByIdOut(Long id) {
        // Implement find by id logic
       return Optional.empty();
    }

    @Override
    public List<PersonaDTO> findAllOut() {
        // Implement find all logic
        return List.of();
    }

    @Override
    public PersonaDTO updatePersonaOut(Long id, PersonaRequest personaRequest) {
        // Validate and sanitize user input data
        // Implement update logic
        return null;
    }

    @Override
    public PersonaDTO deletePersonaOut(Long id) {
        // Implement delete logic
        return null;
    }
}