package com.cccmant.api_mantenimientos.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cccmant.api_mantenimientos.model.Tecnico;
import com.cccmant.api_mantenimientos.repository.AutenticacionRepository;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AutenticacionRepository repository;

    @Override
    public boolean loginTecnico(String email, String contraseña) {
        Optional<Tecnico> tecnicoConsulta = repository.loginTecnico(email, contraseña);
        return tecnicoConsulta.isPresent();
    }

}
