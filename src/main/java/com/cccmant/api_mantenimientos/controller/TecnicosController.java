package com.cccmant.api_mantenimientos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
