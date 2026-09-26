package com.portfolio.gym.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "detalle_compra")
public class DetalleCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_compra")
    private Integer idDetalleCompra;

    @Column(name = "cantidad_comprada")
    private Integer cantidadComprada;

    @Column(name = "precio_coste_unitario")
    private Double precioCosteUnitario;

    @Column(name = "porcentaje_impuesto_aplicado")
    private Double porcentajeImpuestoAplicado;

    @ManyToOne
    @JoinColumn(name = "id_compra_fk")
    private Compra compra;

    @ManyToOne
    @JoinColumn(name = "id_suplemento_fk")
    private Suplemento suplemento;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public DetalleCompra() {
    }

    public DetalleCompra(Integer cantidadComprada, Double precioCosteUnitario, Double porcentajeImpuestoAplicado,
                         Compra compra, Suplemento suplemento) {
        this.cantidadComprada = cantidadComprada;
        this.precioCosteUnitario = precioCosteUnitario;
        this.porcentajeImpuestoAplicado = porcentajeImpuestoAplicado;
        this.compra = compra;
        this.suplemento = suplemento;
    }

    public Integer getIdDetalleCompra() {
        return idDetalleCompra;
    }

    public void setIdDetalleCompra(Integer idDetalleCompra) {
        this.idDetalleCompra = idDetalleCompra;
    }

    public Integer getCantidadComprada() {
        return cantidadComprada;
    }

    public void setCantidadComprada(Integer cantidadComprada) {
        this.cantidadComprada = cantidadComprada;
    }

    public Double getPrecioCosteUnitario() {
        return precioCosteUnitario;
    }

    public void setPrecioCosteUnitario(Double precioCosteUnitario) {
        this.precioCosteUnitario = precioCosteUnitario;
    }

    public Double getPorcentajeImpuestoAplicado() {
        return porcentajeImpuestoAplicado;
    }

    public void setPorcentajeImpuestoAplicado(Double porcentajeImpuestoAplicado) {
        this.porcentajeImpuestoAplicado = porcentajeImpuestoAplicado;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Suplemento getSuplemento() {
        return suplemento;
    }

    public void setSuplemento(Suplemento suplemento) {
        this.suplemento = suplemento;
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
