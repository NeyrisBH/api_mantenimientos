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
@Table(name = "cmms_controlcorrectivo")
public class ControlCorrectivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Column(name = "N1")
    private String n1;

    @Column(name = "N2")
    private String n2;

    @Column(name = "N3")
    private String n3;

    @Column(name = "N4")
    private String n4;

    @Column(name = "N5")
    private String n5;

    @ManyToOne
    @JoinColumn(name = "CodigoEquipo")
    private long equipo;

    @ManyToOne
    @JoinColumn(name = "IdentificacionTecnico")
    private long tecnico;

    public ControlCorrectivo(String fecha, String p1, String p2, String p3, String p4, String p5, String n1, String n2,
            String n3, String n4, String n5, long equipo, long tecnico) {
        this.fecha = fecha;
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
        this.p5 = p5;
        this.n1 = n1;
        this.n2 = n2;
        this.n3 = n3;
        this.n4 = n4;
        this.n5 = n5;
        this.equipo = equipo;
        this.tecnico = tecnico;
    }

    // METODOS GET
    public long getId() {
        return codigo;
    }

    public String getFecha() {
        return fecha;
    }

    public String getP1() {
        return p1;
    }

    public String getP2() {
        return p2;
    }

    public String getP3() {
        return p3;
    }

    public String getP4() {
        return p4;
    }

    public String getP5() {
        return p5;
    }

    public String getN1() {
        return n1;
    }

    public String getN2() {
        return n2;
    }

    public String getN3() {
        return n3;
    }

    public String getN4() {
        return n4;
    }

    public String getN5() {
        return n5;
    }

    public long getEquipo() {
        return equipo;
    }

    public long getTecnico() {
        return tecnico;
    }

    // METODOS SET
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setP1(String p1) {
        this.p1 = p1;
    }

    public void setP2(String p2) {
        this.p2 = p2;
    }

    public void setP3(String p3) {
        this.p3 = p3;
    }

    public void setP4(String p4) {
        this.p4 = p4;
    }

    public void setP5(String p5) {
        this.p5 = p5;
    }

    public void setN1(String n1) {
        this.n1 = n1;
    }

    public void setN2(String n2) {
        this.n2 = n2;
    }

    public void setN3(String n3) {
        this.n3 = n3;
    }

    public void setN4(String n4) {
        this.n4 = n4;
    }

    public void setN5(String n5) {
        this.n5 = n5;
    }

    public void setEquipo(long equipo) {
        this.equipo = equipo;
    }

    public void setTecnico(long tecnico) {
        this.tecnico = tecnico;
    }

    @Override
    public String toString() {
        return "Control correctivo [Codigo=" + codigo + ", Fecha=" + fecha + ", P1=" + p1 + ", P2=" + p2 + ", P3=" + p3
                + ", P4=" + p4 + ", P5=" + p5 + ", N1=" + n1 + ", N2= " + n2 + ", N3=" + n3
                + ", N4=" + n4 + ", N5=" + n5 + ", Equipo=" + equipo + ", Tecnico=" + tecnico + "]";
    }
}
