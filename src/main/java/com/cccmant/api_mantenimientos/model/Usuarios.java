package com.cccmant.api_mantenimientos.model;

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

    public Usuarios() {
        super();
    }

    public Usuarios(String nombres, String apellidos, String email, Long ubicacion) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.email = email;
        this.ubucacion = ubicacion;
    }

    // METODOS GET
    public long getId() {
        return codigo;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getCorreoElectronico() {
        return email;
    }

    public Long getUbicacionCodigo() {
        return ubucacion;
    }

    // METODOS SET
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setCorreoElectronico(String email) {
        this.email = email;
    }

    public void setUbicacionCodigo(Long ubicacion) {
        this.ubucacion = ubicacion;
    }

    @Override
    public String toString() {
        return "Usuario [codigo=" + codigo + ", nombres=" + nombres + ", apellidos=" + apellidos + ", correo="
                + email
                + ", ubicacion=" + ubucacion + "]";
    }
}
