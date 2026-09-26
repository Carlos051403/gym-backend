package com.portfolio.gym.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "usuario_rutina")
public class UsuarioRutina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario_rutina")
    private Integer idUsuarioRutina;

    @Column(name = "fecha_inicio")
    private LocalDateTime fechaInicio;

    @Column(name = "activa")
    private Boolean activa;

    @ManyToOne
    @JoinColumn(name = "id_usuario_fk")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_rutina_fk")
    private Rutina rutina;

    public UsuarioRutina() {
    }

    public UsuarioRutina(LocalDateTime fechaInicio, Boolean activa, Usuario usuario, Rutina rutina) {
        this.fechaInicio = fechaInicio;
        this.activa = activa;
        this.usuario = usuario;
        this.rutina = rutina;
    }

    public Integer getIdUsuarioRutina() {
        return idUsuarioRutina;
    }

    public void setIdUsuarioRutina(Integer idUsuarioRutina) {
        this.idUsuarioRutina = idUsuarioRutina;
    }

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Boolean getActiva() {
        return activa;
    }

    public void setActiva(Boolean activa) {
        this.activa = activa;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Rutina getRutina() {
        return rutina;
    }

    public void setRutina(Rutina rutina) {
        this.rutina = rutina;
    }
}
