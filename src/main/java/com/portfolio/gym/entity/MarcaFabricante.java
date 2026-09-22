package com.portfolio.gym.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "marca_fabricante")
public class MarcaFabricante {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id_marca_fabricante")
    private Integer idMarcaFabricante;

    @Column(name = "nombre_marca_fabricante")
    private String nombreMarcaFabricante;

    public MarcaFabricante() {
    }

    public MarcaFabricante(String nombreMarcaFabricante) {
        this.nombreMarcaFabricante = nombreMarcaFabricante;
    }

    public Integer getIdMarcaFabricante() {
        return idMarcaFabricante;
    }

    public void setIdMarcaFabricante(Integer idMarcaFabricante) {
        this.idMarcaFabricante = idMarcaFabricante;
    }

    public String getNombreMarcaFabricante() {
        return nombreMarcaFabricante;
    }

    public void setNombreMarcaFabricante(String nombreMarcaFabricante) {
        this.nombreMarcaFabricante = nombreMarcaFabricante;
    }
}

