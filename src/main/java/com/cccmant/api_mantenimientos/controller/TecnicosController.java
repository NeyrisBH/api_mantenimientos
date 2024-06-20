package com.cccmant.api_mantenimientos.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cccmant.api_mantenimientos.model.Tecnico;
import com.cccmant.api_mantenimientos.service.TecnicosService;

@RestController
@RequestMapping("/api/v1/tecnicos")
public class TecnicosController {

    @Autowired
    private TecnicosService service;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping
    public ResponseEntity<?> consultarTecnicos() {
        return ResponseEntity.status(HttpStatus.OK).body(service.consultarTecnicos());
    }

    @PostMapping
    public ResponseEntity<?> crearTecnico(@RequestBody Tecnico tecnico) {
    Optional<Tecnico> tecnicoExistente = service.consultarTecnicoPorIdentificacion(tecnico.getIdentificacion());
        if (tecnicoExistente.isPresent()) {
            System.out.println(tecnico.getIdentificacion());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ya existe un técnico con la misma identificación.");
        } else {
            String encrypPassword = passwordEncoder.encode(tecnico.getContraseña());
            tecnico.setContraseña(encrypPassword);
            return ResponseEntity.status(HttpStatus.CREATED).body(service.crearTecnico(tecnico));
        }
    }
}
