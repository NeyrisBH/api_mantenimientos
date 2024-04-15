package com.cccmant.api_mantenimientos.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cmms_tecnicos")
public class Tecnico {

    @Id
    @Column(name = "Identificacion")
    private long identificacion;

    @Column(name = "Nombres")
    private String nombres;

    @Column(name = "Apellidos")
    private String apellidos;

    @Column(name = "Telefono")
    private long telefono;

    @Column(name = "CorreoElectronico")
    private String email;

    @Column(name = "HorasLaborales")
    private long horas;

    @Column(name = "Contraseña")
    private String contraseña;

    public Tecnico(long identificacion, String nombres, String apellidos, long telefono, String correo, long horas,
            String contraseña) {
        this.identificacion = identificacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.email = correo;
        this.horas = horas;
        this.contraseña = contraseña;
    }

    public long getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(long identificacion) {
        this.identificacion = identificacion;
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

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String correo) {
        this.email = correo;
    }

    public long getHoras() {
        return horas;
    }

    public void setHoras(long horas) {
        this.horas = horas;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {
        return "Tecnico [identificacion=" + identificacion + ", nombres=" + nombres + ", apellidos=" + apellidos
                + ", telefono=" + telefono + ", correo=" + email + ", horas=" + horas + ", contraseña=" + contraseña
                + "]";
    }
}
