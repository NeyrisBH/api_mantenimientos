package com.cccmant.api_mantenimientos.controller;

import java.util.List;
import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
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
import io.jsonwebtoken.Jwts;
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

    @PostMapping()
    public ResponseEntity<?> consultarToken(@RequestBody Tecnico tecnico) {
        boolean respuesta = servicio.loginTecnico(tecnico.getEmail(),
                tecnico.getContraseña());
        if (!respuesta) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        Optional<Tecnico> tecnicoConsulta = servicioTecnico.consultarTecnico(tecnico.getEmail());
        String token = JwtUtil.crearToken(tecnico.getEmail(), tecnicoConsulta.get().getRol());
        System.out.println(token);
        return ResponseEntity.ok(new JSONObject().put("token", token).toString());
    }

    @SuppressWarnings({ "deprecation", "unchecked" })
    @GetMapping("refresh")
    public ResponseEntity<?> actualizarToken(HttpServletRequest request) {
        String token2 = null;
        try {
            String headers = request.getHeader(HEADER);
            if (headers == null) {
                SecurityContextHolder.clearContext();
            } else if (headers.startsWith(PREFIX)) {
                String token = headers.replace(PREFIX, "");
                Claims contenido = Jwts.parser().setSigningKey(JwtUtil.KEYWORD.getBytes()).build()
                        .parseClaimsJws(token).getBody();
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
