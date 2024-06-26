package com.codigo.miprimeraapig.service.impl;

import com.codigo.miprimeraapig.entity.UsuariosEntity;
import com.codigo.miprimeraapig.repository.UsuariosRepository;
import com.codigo.miprimeraapig.service.UsuariosService;
import org.springframework.stereotype.Service;

@Service
public class UsuariosServiceImpl implements UsuariosService {


    private final UsuariosRepository usuariosRepository;

    public UsuariosServiceImpl(UsuariosRepository usuariosRepository) {

        this.usuariosRepository = usuariosRepository;
    }

    @Override
    public UsuariosEntity crearUsuario(UsuariosEntity usuariosEntity) {

        return usuariosRepository.save(usuariosEntity);
    }
}
