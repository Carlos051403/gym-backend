package com.portfolio.gym.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "rutina")
public class Rutina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rutina")
    private Integer idRutina;

    @Column(name = "nombre_rutina")
    private String nombreRutina;

    @ManyToOne
    @JoinColumn(name = "id_objetivo_fk")
    private Objetivo objetivo;

    public Rutina() {
    }

    public Rutina(String nombreRutina, Objetivo objetivo) {
        this.nombreRutina = nombreRutina;
        this.objetivo = objetivo;
    }

    public Integer getIdRutina() {
        return idRutina;
    }

    public void setIdRutina(Integer idRutina) {
        this.idRutina = idRutina;
    }

    public String getNombreRutina() {
        return nombreRutina;
    }

    public void setNombreRutina(String nombreRutina) {
        this.nombreRutina = nombreRutina;
    }

    public Objetivo getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(Objetivo objetivo) {
        this.objetivo = objetivo;
    }
}
