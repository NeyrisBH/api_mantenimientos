package com.cccmant.api_mantenimientos.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @GetMapping
    public ResponseEntity<?> consultarTecnicos() {
        return ResponseEntity.status(HttpStatus.OK).body(service.consultarTecnicos());
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> crearTecnico(@RequestBody Tecnico tecnico) {
        Optional<Tecnico> tecnicoCrear = service.consultarTecnico(tecnico.getEmail());
        if (tecnicoCrear.isPresent()) {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(service.crearTecnico(tecnico));
    }
}
