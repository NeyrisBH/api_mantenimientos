package com.cccmant.api_mantenimientos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cccmant.api_mantenimientos.service.AuthService;
import com.cccmant.api_mantenimientos.service.TecnicosService;

@RestController
@RequestMapping("/api/token")
public class AuthController {

    @Autowired
    private AuthService servicio;
    private final String HEADER = "Authorization";
    private final String PREFIX = "Bearer";

    @Autowired
    private TecnicosService servicioTecnico;

    // @PostMapping()
    // public ResponseEntity<?> consultarToken(@RequestBody Tecnico tecnico){
    // boolean respuesta = servicio.loginTecnico(tecnico.getEmail(),
    // tecnico.getContraseña());
    // if (!respuesta) {
    // return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    // }
    // Optional<Tecnico> tecnicoConsulta =
    // servicioTecnico.consultarTecnico(tecnico.getEmail());
    // String token = JwtUtil

    // }
};
