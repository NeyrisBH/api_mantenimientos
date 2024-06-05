package com.cccmant.api_mantenimientos;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.cccmant.api_mantenimientos.util.JwtUtil;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings({"unchecked" })
@Component
public class JwtFilter extends OncePerRequestFilter {
    private final String HEADER = "Authorization";
    private final String PREFIX = "Bearer ";

    private final JwtUtil jwtUtil;

    public JwtFilter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        try {
            String headers = request.getHeader(HEADER);
            if (headers == null) {
                SecurityContextHolder.clearContext();
            } else if (headers.startsWith(PREFIX)) {
                String token = headers.replace(PREFIX, "");
                Claims contenido = jwtUtil.obtenerClaims(token);
                String email = (String) contenido.get("email");
                System.out.println(email);
                List<String> rolesString = (List<String>) contenido.get("authorities");
                UsernamePasswordAuthenticationToken autorizacion = new UsernamePasswordAuthenticationToken(email,
                        null, rolesString.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
                SecurityContextHolder.getContext().setAuthentication(autorizacion);
            } else {
                SecurityContextHolder.clearContext();
            }
            filterChain.doFilter(request, response);
        } catch (ExpiredJwtException | UnsupportedJwtException e) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.sendError(HttpServletResponse.SC_FORBIDDEN, e.getMessage());
        }
    }
}