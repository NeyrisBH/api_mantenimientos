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
    private long codigo;

    @Column(name = "FechaInicio")
    private String f_inicio;

    @Column(name = "FechaFinal")
    private String f_final;

    @ManyToOne
    @JoinColumn(name = "FallaCodigo")
    private long falla;

    @ManyToOne
    @JoinColumn(name = "TecnicoIdentificacion")
    private long tecnico;

}
