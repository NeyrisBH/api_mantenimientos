package com.cccmant.api_mantenimientos.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cmms_proveedores")
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Identificacion")
    private long identificacion;

    @Column(name = "RazonSocial")
    private String razonSocial;

    @Column(name = "Telefono")
    private long telefono;

    @Column(name = "CorreoElectronico")
    private String correo;

    @Column(name = "Notas")
    private String notas;

    public Proveedor() {
        super();
    }

    public Proveedor(long identificacion, String razonSocial, long telefono, String correo, String notas) {
        this.identificacion = identificacion;
        this.razonSocial = razonSocial;
        this.telefono = telefono;
        this.correo = correo;
        this.notas = notas;
    }

    public long getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(long identificacion) {
        this.identificacion = identificacion;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    @Override
    public String toString() {
        return "Proveedor [identificacion=" + identificacion + ", razonSocial=" + razonSocial + ", telefono=" + telefono
                + ", correo=" + correo + ", notas=" + notas + "]";
    }
}
