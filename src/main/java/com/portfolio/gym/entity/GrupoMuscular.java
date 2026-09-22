package com.portfolio.gym.entity;

import jakarta.persistence.*;

@Entity
@Table( name = "grupo_muscular")
public class GrupoMuscular {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_grupo_muscular")
    private Integer idGrupoMuscular;

    @Column(name = "nombre_grupo_muscular")
    private String nombreGrupoMuscular;

    public GrupoMuscular() {
    }

    public GrupoMuscular(String nombreGrupoMuscular) {
        this.nombreGrupoMuscular = nombreGrupoMuscular;
    }

    public Integer getIdGrupoMuscular() {
        return idGrupoMuscular;
    }

    public void setIdGrupoMuscular(Integer idGrupoMuscular) {
        this.idGrupoMuscular = idGrupoMuscular;
    }

    public String getNombreGrupoMuscular() {
        return nombreGrupoMuscular;
    }

    public void setNombreGrupoMuscular(String nombreGrupoMuscular) {
        this.nombreGrupoMuscular = nombreGrupoMuscular;
    }
}
