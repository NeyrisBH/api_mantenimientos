package com.cccmant.api_mantenimientos.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cmms_usuarios")

public class Usuarios {
    @Id
    @Column(name = "Codigo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;

    @Column(name = "Nombres")
    private String nombres;

    @Column(name = "Apellidos")
    private String apellidos;

    @Column(name = "CorreoElectronico")
    private String email;

    @Column(name = "UbicacionCodigo")
    private Long ubucacion;

    @CreationTimestamp
    @Column(name = "createdAt", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updatedAt", nullable = false)
    private LocalDateTime updatedAt;

    public Usuarios() {
        super();
    }

    public Usuarios(long codigo, String nombres, String apellidos, String email, Long ubucacion,
            LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.codigo = codigo;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.email = email;
        this.ubucacion = ubucacion;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    
    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getUbucacion() {
        return ubucacion;
    }

    public void setUbucacion(Long ubucacion) {
        this.ubucacion = ubucacion;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Usuario [codigo=" + codigo + ", nombres=" + nombres + ", apellidos=" + apellidos + ", correo="
                + email
                + ", ubicacion=" + ubucacion + "]";
    }
}
