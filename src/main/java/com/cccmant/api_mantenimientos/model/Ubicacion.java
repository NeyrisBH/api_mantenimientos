package com.cccmant.api_mantenimientos.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cmms_ubicaciones")
public class Ubicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Codigo")
    private long codigo;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Sede")
    private String sede;

    @ManyToOne
    @JoinColumn(name = "UbicacionCodigo", referencedColumnName = "Codigo")
    private Ubicacion ubicacion;

    public Ubicacion(String nombre, String sede) {
        this.nombre = nombre;
        this.sede = sede;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Override
    public String toString() {
        return "Ubicacion [codigo=" + codigo + ", nombre=" + nombre + ", sede=" + sede + ", ubicacion=" + ubicacion
                + "]";
    }
}
