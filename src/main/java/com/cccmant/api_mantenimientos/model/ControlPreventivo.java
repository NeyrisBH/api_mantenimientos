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
@Table(name = "cmms_controlpreventivo")
public class ControlPreventivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Codigo")
    private long codigo;

    @Column(name = "Fecha")
    private String fecha;

    @Column(name = "P1")
    private String p1;

    @Column(name = "P2")
    private String p2;

    @Column(name = "P3")
    private String p3;

    @Column(name = "P4")
    private String p4;

    @Column(name = "P5")
    private String p5;

    @Column(name = "P6")
    private String p6;

    @Column(name = "P7")
    private String p7;

    @Column(name = "P8")
    private String p8;

    @Column(name = "P9")
    private String p9;

    @ManyToOne
    @JoinColumn(name = "CodigoEquipo", referencedColumnName = "Codigo")
    private Equipo equipo;

    @ManyToOne
    @JoinColumn(name = "IdentificacionTecnico", referencedColumnName = "Identificacion")
    private Tecnico tecnico;

    public ControlPreventivo() {
        super();
    }

    public ControlPreventivo(String fecha, String p1, String p2, String p3, String p4, String p5, String p6, String p7,
            String p8, String p9, Equipo equipo, Tecnico tecnico) {
        this.fecha = fecha;
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
        this.p5 = p5;
        this.p6 = p6;
        this.p7 = p7;
        this.p8 = p8;
        this.p9 = p9;
        this.equipo = equipo;
        this.tecnico = tecnico;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getP1() {
        return p1;
    }

    public void setP1(String p1) {
        this.p1 = p1;
    }

    public String getP2() {
        return p2;
    }

    public void setP2(String p2) {
        this.p2 = p2;
    }

    public String getP3() {
        return p3;
    }

    public void setP3(String p3) {
        this.p3 = p3;
    }

    public String getP4() {
        return p4;
    }

    public void setP4(String p4) {
        this.p4 = p4;
    }

    public String getP5() {
        return p5;
    }

    public void setP5(String p5) {
        this.p5 = p5;
    }

    public String getP6() {
        return p6;
    }

    public void setP6(String p6) {
        this.p6 = p6;
    }

    public String getP7() {
        return p7;
    }

    public void setP7(String p7) {
        this.p7 = p7;
    }

    public String getP8() {
        return p8;
    }

    public void setP8(String p8) {
        this.p8 = p8;
    }

    public String getP9() {
        return p9;
    }

    public void setP9(String p9) {
        this.p9 = p9;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    @Override
    public String toString() {
        return "ControlPreventivo [codigo=" + codigo + ", fecha=" + fecha + ", p1=" + p1 + ", p2=" + p2 + ", p3=" + p3
                + ", p4=" + p4 + ", p5=" + p5 + ", p6=" + p6 + ", p7=" + p7 + ", p8=" + p8 + ", p9=" + p9 + ", equipo="
                + equipo + ", tecnico=" + tecnico + "]";
    }
}