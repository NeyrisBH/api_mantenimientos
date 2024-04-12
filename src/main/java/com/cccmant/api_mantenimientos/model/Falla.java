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
@Table(name = "cmms_fallas")
public class Falla {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Codigo")
    private long codigo;

    @Column(name = "Motivo")
    private String motivo;

    @Column(name = "Fecha")
    private String fecha;

    @ManyToOne
    @JoinColumn(name = "CodigoEquipo", referencedColumnName = "Codigo")
    private Equipo equipo;

    public Falla(String motivo, String fecha, Equipo equipo) {
        this.motivo = motivo;
        this.fecha = fecha;
        this.equipo = equipo;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    @Override
    public String toString() {
        return "Falla [codigo=" + codigo + ", motivo=" + motivo + ", fecha=" + fecha + ", equipo=" + equipo + "]";
    }
}
