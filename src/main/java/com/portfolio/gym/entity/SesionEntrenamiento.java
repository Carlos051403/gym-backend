package com.portfolio.gym.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "sesion_entrenamiento")
public class SesionEntrenamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sesion_entrenamiento")
    private Integer idSesionEntrenamiento;

    @Column(name = "fecha_sesion_entenamiento")
    private LocalDateTime fechaSesionEntrenamiento;

    @ManyToOne
    @JoinColumn(name = "id_cliente_fk")
    private Usuario cliente;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime  updatedAt;

    public SesionEntrenamiento() {
    }

    public SesionEntrenamiento(LocalDateTime fechaSesionEntrenamiento, Usuario cliente, LocalDateTime createdAt,
                               LocalDateTime updatedAt) {
        this.fechaSesionEntrenamiento = fechaSesionEntrenamiento;
        this.cliente = cliente;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getIdSesionEntrenamiento() {
        return idSesionEntrenamiento;
    }

    public void setIdSesionEntrenamiento(Integer idSesionEntrenamiento) {
        this.idSesionEntrenamiento = idSesionEntrenamiento;
    }

    public LocalDateTime getFechaSesionEntrenamiento() {
        return fechaSesionEntrenamiento;
    }

    public void setFechaSesionEntrenamiento(LocalDateTime fechaSesionEntrenamiento) {
        this.fechaSesionEntrenamiento = fechaSesionEntrenamiento;
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
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
