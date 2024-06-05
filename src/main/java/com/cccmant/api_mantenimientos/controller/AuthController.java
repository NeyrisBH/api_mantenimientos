package com.cccmant.api_mantenimientos.controller;

import java.util.List;
import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cccmant.api_mantenimientos.model.Tecnico;
import com.cccmant.api_mantenimientos.service.AuthService;
import com.cccmant.api_mantenimientos.service.TecnicosService;
import com.cccmant.api_mantenimientos.util.JwtUtil;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/token")
public class AuthController {

    @Autowired
    private AuthService servicio;
    private final String HEADER = "Authorization";
    private final String PREFIX = "Bearer";

    @Autowired
    private TecnicosService servicioTecnico;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping()
    public ResponseEntity<?> consultarToken(@RequestBody Tecnico tecnico) {
        Optional<Tecnico> tecnicoConsulta = servicioTecnico.consultarTecnico(tecnico.getEmail());
        if (tecnicoConsulta.isPresent()) {
            Tecnico tecnicoToken = tecnicoConsulta.get();
            if (passwordEncoder.matches(tecnico.getContraseña(), tecnicoToken.getContraseña())) {
                String token = JwtUtil.crearToken(tecnicoToken.getEmail(), tecnicoToken.getRol());
                return  ResponseEntity.ok(new JSONObject().put("token", token).toString());
            }
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @SuppressWarnings({"unchecked" })
    @GetMapping("refresh")
    public ResponseEntity<?> actualizarToken(HttpServletRequest request) {
        String token2 = null;
        try {
            String headers = request.getHeader(HEADER);
            if (headers == null) {
                SecurityContextHolder.clearContext();
            } else if (headers.startsWith(PREFIX)) {
                String token = headers.replace(PREFIX, "");
                Claims contenido = new JwtUtil().obtenerClaims(token);
                String email = (String) contenido.get("email");
                System.out.println(email);
                List<String> rolesString = (List<String>) contenido.get("authorities");
                token2 = JwtUtil.crearToken(email, rolesString.get(0));
                System.out.println(token2);
            } else {
                SecurityContextHolder.clearContext();
            }
        } catch (ExpiredJwtException | UnsupportedJwtException e) {

        }
        return ResponseEntity.ok(new JSONObject().put("token", token2).toString());
    }
};
