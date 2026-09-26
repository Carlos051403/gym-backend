package com.portfolio.gym.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "detalle_rutina")
public class DetalleRutina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_programa_entrenamiento")
    private Integer idProgramaEntrenamiento;

    @Column(name = "series")
    private Integer series;

    @Column(name = "repeticiones")
    private Integer repeticiones;

    @Column(name = "descanso_segundos")
    private Integer descansoSegundos;

    @Enumerated(EnumType.STRING)
    @Column(name = "dia_semana")
    private DiaSemana diaSemana;

    @Column(name = "orden_ejercicio")
    private Integer ordenEjercicio;

    @ManyToOne
    @JoinColumn(name = "id_ejercicio_fk")
    private Ejercicio ejercicio;

    @ManyToOne
    @JoinColumn(name = "id_rutina_fk")
    private Rutina rutina;

    public DetalleRutina() {
    }

    public DetalleRutina(Integer series, Integer repeticiones, Integer descansoSegundos, DiaSemana diaSemana, Integer ordenEjercicio, Ejercicio ejercicio, Rutina rutina) {
        this.series = series;
        this.repeticiones = repeticiones;
        this.descansoSegundos = descansoSegundos;
        this.diaSemana = diaSemana;
        this.ordenEjercicio = ordenEjercicio;
        this.ejercicio = ejercicio;
        this.rutina = rutina;
    }

    public Integer getIdProgramaEntrenamiento() {
        return idProgramaEntrenamiento;
    }

    public void setIdProgramaEntrenamiento(Integer idProgramaEntrenamiento) {
        this.idProgramaEntrenamiento = idProgramaEntrenamiento;
    }

    public Integer getSeries() {
        return series;
    }

    public void setSeries(Integer series) {
        this.series = series;
    }

    public Integer getRepeticiones() {
        return repeticiones;
    }

    public void setRepeticiones(Integer repeticiones) {
        this.repeticiones = repeticiones;
    }

    public Integer getDescansoSegundos() {
        return descansoSegundos;
    }

    public void setDescansoSegundos(Integer descansoSegundos) {
        this.descansoSegundos = descansoSegundos;
    }

    public DiaSemana getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(DiaSemana diaSemana) {
        this.diaSemana = diaSemana;
    }

    public Integer getOrdenEjercicio() {
        return ordenEjercicio;
    }

    public void setOrdenEjercicio(Integer ordenEjercicio) {
        this.ordenEjercicio = ordenEjercicio;
    }

    public Ejercicio getEjercicio() {
        return ejercicio;
    }

    public void setEjercicio(Ejercicio ejercicio) {
        this.ejercicio = ejercicio;
    }

    public Rutina getRutina() {
        return rutina;
    }

    public void setRutina(Rutina rutina) {
        this.rutina = rutina;
    }
}
