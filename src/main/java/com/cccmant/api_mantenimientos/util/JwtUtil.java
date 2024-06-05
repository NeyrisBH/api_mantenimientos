package com.cccmant.api_mantenimientos.util;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.crypto.SecretKey;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@SuppressWarnings("deprecation")

@Component
public class JwtUtil {
    
    private static final SecretKey SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS512);

    public static String crearToken(String email, String rol) {
        List<GrantedAuthority> grantedAuthories = AuthorityUtils.commaSeparatedStringToAuthorityList(rol);
        String jwt = Jwts.builder()
                .setId("jwt" + email)
                .claim("email", email)
                .claim("authorities", grantedAuthories.stream()
                        .map(GrantedAuthority::getAuthority)
                        .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 900000))
                .signWith(SECRET_KEY)
                .compact();
        return jwt;
    }

    public Claims obtenerClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}