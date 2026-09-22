package com.portfolio.gym.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "impuesto")
public class Impuesto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_impuesto")
    private Integer idImpuesto;

    @Column(name = "nombre_impuesto")
    private String nombreImpuesto;

    @Column(name = "porcentaje_impuesto")
    private Double porcentajeImpuesto;

    public Impuesto() {
    }

    public Impuesto(String nombreImpuesto, Double porcentajeImpuesto) {
        this.nombreImpuesto = nombreImpuesto;
        this.porcentajeImpuesto = porcentajeImpuesto;
    }

    public Integer getIdImpuesto() {
        return idImpuesto;
    }

    public void setIdImpuesto(Integer idImpuesto) {
        this.idImpuesto = idImpuesto;
    }

    public String getNombreImpuesto() {
        return nombreImpuesto;
    }

    public void setNombreImpuesto(String nombreImpuesto) {
        this.nombreImpuesto = nombreImpuesto;
    }

    public Double getPorcentajeImpuesto() {
        return porcentajeImpuesto;
    }

    public void setPorcentajeImpuesto(Double porcentajeImpuesto) {
        this.porcentajeImpuesto = porcentajeImpuesto;
    }
}
