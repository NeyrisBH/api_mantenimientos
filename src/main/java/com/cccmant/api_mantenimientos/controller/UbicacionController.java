package com.cccmant.api_mantenimientos.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cccmant.api_mantenimientos.model.Ubicacion;
import com.cccmant.api_mantenimientos.service.UbicacionService;

@RestController
@RequestMapping("/api/v1/ubicaciones")
public class UbicacionController {
    @Autowired
    UbicacionService servicio;

    @GetMapping
    public ResponseEntity<?> consultarUbicaciones() {
        return ResponseEntity.status(HttpStatus.OK).body(servicio.consultar());
    }

    @PostMapping
    public ResponseEntity<?> crearUbicacion(@RequestBody Ubicacion ubicacion) {
        Optional<Ubicacion> ubicaciionCrear = servicio.consultarPorId(ubicacion.getCodigo());
        if (ubicaciionCrear.isPresent()) {
            System.out.println(ubicacion.getCodigo());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(servicio.crear(ubicacion));
    }
}
