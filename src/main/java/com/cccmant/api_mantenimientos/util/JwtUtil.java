package com.cccmant.api_mantenimientos.util;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@SuppressWarnings("deprecation")
@Component
public class JwtUtil {
    public static final String KEYWORD = "MANTENIMIENTOFULL";

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
                .signWith(SignatureAlgorithm.HS512, KEYWORD.getBytes())
                .compact();
        return jwt;
    }
}
