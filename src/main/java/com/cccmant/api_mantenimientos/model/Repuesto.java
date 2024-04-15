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
@Table(name = "cmms_repuestos")
public class Repuesto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Codigo")
    private long codigo;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Imagen")
    private String imagen;

    @Column(name = "Cantidad")
    private long cantidad;

    @Column(name = "CostoUnitario")
    private long costo;

    @ManyToOne
    @JoinColumn(name = "ProveedorIdentificacion", referencedColumnName = "Identificacion")
    private Proveedor proveedor;

    @ManyToOne
    @JoinColumn(name = "CodigoEquipo", referencedColumnName = "Codigo")
    private Equipo equipo;

    public Repuesto(String nombre, String imagen, long cantidad, long costo, Proveedor proveedor, Equipo equipo) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.cantidad = cantidad;
        this.costo = costo;
        this.proveedor = proveedor;
        this.equipo = equipo;
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

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public long getCantidad() {
        return cantidad;
    }

    public void setCantidad(long cantidad) {
        this.cantidad = cantidad;
    }

    public long getCosto() {
        return costo;
    }

    public void setCosto(long costo) {
        this.costo = costo;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    @Override
    public String toString() {
        return "Repuesto [codigo=" + codigo + ", nombre=" + nombre + ", imagen=" + imagen + ", cantidad=" + cantidad
                + ", costo=" + costo + ", proveedor=" + proveedor + ", equipo=" + equipo + "]";
    }
}
