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
@Table(name = "cmms_ordencorretiva")
public class OrdenCorrectiva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Codigo")
    private long codigo;

    @Column(name = "FechaInicio")
    private String f_inicio;

    @Column(name = "FechaFinal")
    private String f_final;

    @Column(name = "Descripcion")
    private String descripcion;

    @Column(name = "Costo")
    private long costo;

    @Column(name = "Prioridad")
    private String prioridad;

    @Column(name = "CantidadRepuestos")
    private long cantidad;

    @ManyToOne
    @JoinColumn(name = "R1", referencedColumnName = "Codigo")
    private Repuesto r1;

    @ManyToOne
    @JoinColumn(name = "R2", referencedColumnName = "Codigo")
    private Repuesto r2;

    @ManyToOne
    @JoinColumn(name = "R3", referencedColumnName = "Codigo")
    private Repuesto r3;

    @ManyToOne
    @JoinColumn(name = "R4", referencedColumnName = "Codigo")
    private Repuesto r4;

    @ManyToOne
    @JoinColumn(name = "IdentificaciónTecnico", referencedColumnName = "Identificacion")
    private Tecnico tecnico;

    @ManyToOne
    @JoinColumn(name = "CodigoEquipo", referencedColumnName = "Codigo")
    private Equipo equipo;

    public OrdenCorrectiva(String f_inicio, String f_final, String descripcion, long costo, String prioridad,
            long cantidad, Repuesto r1, Repuesto r2, Repuesto r3, Repuesto r4, Tecnico tecnico, Equipo equipo) {
        this.f_inicio = f_inicio;
        this.f_final = f_final;
        this.descripcion = descripcion;
        this.costo = costo;
        this.prioridad = prioridad;
        this.cantidad = cantidad;
        this.r1 = r1;
        this.r2 = r2;
        this.r3 = r3;
        this.r4 = r4;
        this.tecnico = tecnico;
        this.equipo = equipo;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getF_inicio() {
        return f_inicio;
    }

    public void setF_inicio(String f_inicio) {
        this.f_inicio = f_inicio;
    }

    public String getF_final() {
        return f_final;
    }

    public void setF_final(String f_final) {
        this.f_final = f_final;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public long getCosto() {
        return costo;
    }

    public void setCosto(long costo) {
        this.costo = costo;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public long getCantidad() {
        return cantidad;
    }

    public void setCantidad(long cantidad) {
        this.cantidad = cantidad;
    }

    public Repuesto getR1() {
        return r1;
    }

    public void setR1(Repuesto r1) {
        this.r1 = r1;
    }

    public Repuesto getR2() {
        return r2;
    }

    public void setR2(Repuesto r2) {
        this.r2 = r2;
    }

    public Repuesto getR3() {
        return r3;
    }

    public void setR3(Repuesto r3) {
        this.r3 = r3;
    }

    public Repuesto getR4() {
        return r4;
    }

    public void setR4(Repuesto r4) {
        this.r4 = r4;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    @Override
    public String toString() {
        return "OrdenCorrectiva [codigo=" + codigo + ", f_inicio=" + f_inicio + ", f_final=" + f_final
                + ", descripcion=" + descripcion + ", costo=" + costo + ", prioridad=" + prioridad + ", cantidad="
                + cantidad + ", r1=" + r1 + ", r2=" + r2 + ", r3=" + r3 + ", r4=" + r4 + ", tecnico=" + tecnico
                + ", equipo=" + equipo + "]";
    }
}
