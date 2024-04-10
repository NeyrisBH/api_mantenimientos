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

import com.cccmant.api_mantenimientos.model.Usuarios;
import com.cccmant.api_mantenimientos.service.UsuariosService;

//@CrossOrigin(origins = "hthp://localhost:")
@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuariosController {

    @Autowired
    UsuariosService servicio;

    @GetMapping
    public ResponseEntity<?> consultarUsuarios() {
        return ResponseEntity.status(HttpStatus.OK).body(servicio.consultar());
    }

    // @GetMapping("/{id}")
    // public ResponseEntity<?> consultarPorId(@PathVariable Long id){
    // Optional<Usuarios> usuario = servicio.consultarUsuario(null, null)
    // }

    @PostMapping
    public ResponseEntity<?> crearUsuario(@RequestBody Usuarios usuario) {
        Optional<Usuarios> usuarioCrear = servicio.consultarUsuarioPorId(usuario.getId());
        if (usuarioCrear.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(servicio.crear(usuario));
    }
}
