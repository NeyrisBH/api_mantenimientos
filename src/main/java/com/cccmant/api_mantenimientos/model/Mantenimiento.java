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
@Table(name = "cmms_mantenimientos")
public class Mantenimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Codigo")
    private long codigo;

    @Column(name = "FechaInicio")
    private String f_inicio;

    @Column(name = "FechaFinal")
    private String f_final;

    @ManyToOne
    @JoinColumn(name = "FallaCodigo", referencedColumnName = "Codigo")
    private Falla falla;

    @ManyToOne
    @JoinColumn(name = "TecnicoIdentificacion", referencedColumnName = "Identificacion")
    private Tecnico tecnico;

    @ManyToOne
    @JoinColumn(name = "ControlIPCodigo", referencedColumnName = "Codigo")
    private ControlPreventivo preventivo;

    @Column(name = "Descripcion")
    private String descripcion;

    public Mantenimiento(String f_inicio, String f_final, Falla falla, Tecnico tecnico, ControlPreventivo preventivo,
            String descripcion) {
        this.f_inicio = f_inicio;
        this.f_final = f_final;
        this.falla = falla;
        this.tecnico = tecnico;
        this.preventivo = preventivo;
        this.descripcion = descripcion;
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

    public Falla getFalla() {
        return falla;
    }

    public void setFalla(Falla falla) {
        this.falla = falla;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    public ControlPreventivo getPreventivo() {
        return preventivo;
    }

    public void setPreventivo(ControlPreventivo preventivo) {
        this.preventivo = preventivo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Mantenimiento [codigo=" + codigo + ", f_inicio=" + f_inicio + ", f_final=" + f_final + ", falla="
                + falla + ", tecnico=" + tecnico + ", preventivo=" + preventivo + ", descripcion=" + descripcion + "]";
    }
}
