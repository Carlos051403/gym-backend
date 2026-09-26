package com.portfolio.gym.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ejercicio")
public class Ejercicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ejercicio")
    private Integer idEjercicio;

    @Column(name = "nombre_ejercicio")
    private String nombreEjercicio;

    @Column(name = "descripcion_tecnica")
    private String descripcionTecnica;

    @Column(name = "enlace_video")
    private String enlaceVideo;

    @ManyToOne
    @JoinColumn(name = "id_grupo_muscular_fk")
    private GrupoMuscular grupoMuscular;

    public Ejercicio() {
    }

    public Ejercicio(String nombreEjercicio, String descripcionTecnica, String enlaceVideo, GrupoMuscular grupoMuscular) {
        this.nombreEjercicio = nombreEjercicio;
        this.descripcionTecnica = descripcionTecnica;
        this.enlaceVideo = enlaceVideo;
        this.grupoMuscular = grupoMuscular;
    }

    public Integer getIdEjercicio() {

        return idEjercicio;
    }

    public void setIdEjercicio(Integer idEjercicio) {
        this.idEjercicio = idEjercicio;
    }

    public String getNombreEjercicio() {
        return nombreEjercicio;
    }

    public void setNombreEjercicio(String nombreEjercicio) {
        this.nombreEjercicio = nombreEjercicio;
    }

    public String getDescripcionTecnica() {
        return descripcionTecnica;
    }

    public void setDescripcionTecnica(String descripcionTecnica) {
        this.descripcionTecnica = descripcionTecnica;
    }

    public String getEnlaceVideo() {
        return enlaceVideo;
    }

    public void setEnlaceVideo(String enlaceVideo) {
        this.enlaceVideo = enlaceVideo;
    }

    public GrupoMuscular getGrupoMuscular() {
        return grupoMuscular;
    }

    public void setGrupoMuscular(GrupoMuscular grupoMuscular) {
        this.grupoMuscular = grupoMuscular;
    }
}
