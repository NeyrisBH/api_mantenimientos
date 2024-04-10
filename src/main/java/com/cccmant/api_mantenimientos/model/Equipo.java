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
@Table(name = "cmms_equipos")
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Imagen")
    private String imagen;

    @Column(name = "Costo")
    private long costo;

    @Column(name = "Modelo")
    private String modelo;

    @Column(name = "NumeroSerial")
    private String serial;

    @Column(name = "FechaCompra")
    private String fechaCompra;

    @Column(name = "FechaGarantia")
    private String fechaGarantia;

    @Column(name = "Fabricante")
    private String fabricante;

    @ManyToOne
    @JoinColumn(name = "UbicacionCodigo")
    private long ubicacion;

    @Column(name = "PlanMantenimiento")
    private String mantenimientos;

    @ManyToOne
    @JoinColumn(name = "ProveedorIdentificacion")
    private long proveedor;

    @ManyToOne
    @JoinColumn(name = "UsuarioIdentificacion")
    private long usuario;

    @Column(name = "Notas")
    private String notas;

    public Equipo(String nombre, String imagen, long costo, String modelo, String serial, String fechaCompra,
            String fechaGarantia, String fabricante, long ubicacion, String mantenimientos, long proveedor,
            long usuario, String notas) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.costo = costo;
        this.modelo = modelo;
        this.serial = serial;
        this.fechaCompra = fechaCompra;
        this.fechaGarantia = fechaGarantia;
        this.fabricante = fabricante;
        this.ubicacion = ubicacion;
        this.mantenimientos = mantenimientos;
        this.proveedor = proveedor;
        this.usuario = usuario;
        this.notas = notas;
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

    public long getCosto() {
        return costo;
    }

    public void setCosto(long costo) {
        this.costo = costo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public String getFechaGarantia() {
        return fechaGarantia;
    }

    public void setFechaGarantia(String fechaGarantia) {
        this.fechaGarantia = fechaGarantia;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public long getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(long ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getMantenimientos() {
        return mantenimientos;
    }

    public void setMantenimientos(String mantenimientos) {
        this.mantenimientos = mantenimientos;
    }

    public long getProveedor() {
        return proveedor;
    }

    public void setProveedor(long proveedor) {
        this.proveedor = proveedor;
    }

    public long getUsuario() {
        return usuario;
    }

    public void setUsuario(long usuario) {
        this.usuario = usuario;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    @Override
    public String toString() {
        return "Equipo [codigo=" + codigo + ", nombre=" + nombre + ", imagen=" + imagen + ", costo=" + costo
                + ", modelo=" + modelo + ", serial=" + serial + ", fechaCompra=" + fechaCompra + ", fechaGarantia="
                + fechaGarantia + ", fabricante=" + fabricante + ", ubicacion=" + ubicacion + ", mantenimientos="
                + mantenimientos + ", proveedor=" + proveedor + ", usuario=" + usuario + ", notas=" + notas + "]";
    }
}
