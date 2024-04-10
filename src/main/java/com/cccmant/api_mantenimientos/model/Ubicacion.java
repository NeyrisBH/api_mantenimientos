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
    private long codigo;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Sede")
    private String sede;

    @ManyToOne
    @JoinColumn(name = "Codigo", referencedColumnName = "UbicacionCodigo")
    private Ubicacion ubicacion;

    public Ubicacion(String nombre, String sede) {
        this.nombre = nombre;
        this.sede = sede;
    }

    // METODOS GET
    public long getId() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getSede() {
        return sede;
    }

    // METODOS SET
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    @Override
    public java.lang.String toString() {
        return "Ubicacion [codigo=" + codigo + ", nombre=" + nombre + ", sede=" + sede + "]";
    }
}
