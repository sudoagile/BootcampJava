package com.codigo.msramirezdelama.application.controllers;

import com.codigo.ramirezdelama.domain.aggregates.dto.PersonaDTO;
import com.codigo.ramirezdelama.domain.aggregates.request.PersonaRequest;
import com.codigo.ramirezdelama.domain.port.in.PersonaServiceIn;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ms-registroz/v1/persona")
@AllArgsConstructor

public class PersonaController {
    private final PersonaServiceIn personaServiceIn;

    @PostMapping
    public ResponseEntity<PersonaDTO> createPersonaIn(@RequestBody PersonaRequest requestPersona){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(personaServiceIn.createPersonaIn(requestPersona));
    }
    @GetMapping("/{id}")
    public ResponseEntity<PersonaDTO> findByIdIn(@PathVariable Long id){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(personaServiceIn.findByIdIn(id).get());
    }

    @GetMapping("/todos")
    public ResponseEntity<List<PersonaDTO>> findAllIn(){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(personaServiceIn.findAllIn());
    }
    @PutMapping("/{id}")
    public ResponseEntity<PersonaDTO> updatePersonaIn(@PathVariable Long id, @RequestBody PersonaRequest personaRequest){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(personaServiceIn.updatePersonaIn(id,personaRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PersonaDTO> deletePersonaIn(@PathVariable Long id){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(personaServiceIn.deletePersonaIn(id));
    }
}
