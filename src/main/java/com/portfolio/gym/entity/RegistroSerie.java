package com.portfolio.gym.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "registro_serie")
public class RegistroSerie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_registro_serie")
    private Integer idRegistroSerie;

    @ManyToOne
    @JoinColumn(name = "id_sesion_entrenamiento_fk")
    private SesionEntrenamiento sesionEntrenamiento;

    @ManyToOne
    @JoinColumn(name = "id_ejercicio_fk")
    private Ejercicio ejercicio;

    @Column(name = "peso_levantado")
    private Double pesoLevantado;

    @Column(name = "repeticiones_logradas")
    private Integer repeticionesLogradas;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public RegistroSerie() {
    }

    public RegistroSerie(SesionEntrenamiento sesionEntrenamiento, Ejercicio ejercicio, Double pesoLevantado,
                         Integer repeticionesLogradas) {
        this.sesionEntrenamiento = sesionEntrenamiento;
        this.ejercicio = ejercicio;
        this.pesoLevantado = pesoLevantado;
        this.repeticionesLogradas = repeticionesLogradas;
    }

    public Integer getIdRegistroSerie() {
        return idRegistroSerie;
    }

    public void setIdRegistroSerie(Integer idRegistroSerie) {
        this.idRegistroSerie = idRegistroSerie;
    }

    public SesionEntrenamiento getSesionEntrenamiento() {
        return sesionEntrenamiento;
    }

    public void setSesionEntrenamiento(SesionEntrenamiento sesionEntrenamiento) {
        this.sesionEntrenamiento = sesionEntrenamiento;
    }

    public Ejercicio getEjercicio() {
        return ejercicio;
    }

    public void setEjercicio(Ejercicio ejercicio) {
        this.ejercicio = ejercicio;
    }

    public Double getPesoLevantado() {
        return pesoLevantado;
    }

    public void setPesoLevantado(Double pesoLevantado) {
        this.pesoLevantado = pesoLevantado;
    }

    public Integer getRepeticionesLogradas() {
        return repeticionesLogradas;
    }

    public void setRepeticionesLogradas(Integer repeticionesLogradas) {
        this.repeticionesLogradas = repeticionesLogradas;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
