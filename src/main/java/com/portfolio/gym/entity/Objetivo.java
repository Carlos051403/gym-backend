package com.portfolio.gym.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "objetivo")
public class Objetivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_objetivo")
    private Integer idObjetivo;

    @Column (name = "nombre_objetivo")
    private String nombreObjetivo;

    public Objetivo() {
    }

    public Objetivo(String nombreObjetivo) {
        this.nombreObjetivo = nombreObjetivo;
    }

    public Integer getIdObjetivo() {
        return idObjetivo;
    }

    public void setIdObjetivo(Integer idObjetivo) {
        this.idObjetivo = idObjetivo;
    }

    public String getNombreObjetivo() {
        return nombreObjetivo;
    }

    public void setNombreObjetivo(String nombreObjetivo) {
        this.nombreObjetivo = nombreObjetivo;
    }
}
