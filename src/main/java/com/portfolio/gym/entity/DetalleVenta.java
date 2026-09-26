package com.portfolio.gym.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "detalle_venta")
public class DetalleVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_venta")
    private Integer idDetalleVenta;

    @Column(name = "cantidad_vendida")
    private Integer cantidadVendida;

    @Column(name = "precio_unitario_venta")
    private Double precioUnitarioVenta;

    @Column(name = "porcentaje_impuesto_aplicado")
    private Double porcentajeImpuestoAplicado;

    @ManyToOne
    @JoinColumn(name = "id_venta_fk")
    private Venta venta;

    @ManyToOne
    @JoinColumn(name = "id_suplemento_fk")
    private Suplemento suplemento;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public DetalleVenta() {
    }

    public DetalleVenta(Integer cantidadVendida, Double precioUnitarioVenta, Double porcentajeImpuestoAplicado,
                        Venta venta, Suplemento suplemento) {
        this.cantidadVendida = cantidadVendida;
        this.precioUnitarioVenta = precioUnitarioVenta;
        this.porcentajeImpuestoAplicado = porcentajeImpuestoAplicado;
        this.venta = venta;
        this.suplemento = suplemento;
    }

    public Integer getIdDetalleVenta() {
        return idDetalleVenta;
    }

    public void setIdDetalleVenta(Integer idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }

    public Integer getCantidadVendida() {
        return cantidadVendida;
    }

    public void setCantidadVendida(Integer cantidadVendida) {
        this.cantidadVendida = cantidadVendida;
    }

    public Double getPrecioUnitarioVenta() {
        return precioUnitarioVenta;
    }

    public void setPrecioUnitarioVenta(Double precioUnitarioVenta) {
        this.precioUnitarioVenta = precioUnitarioVenta;
    }

    public Double getPorcentajeImpuestoAplicado() {
        return porcentajeImpuestoAplicado;
    }

    public void setPorcentajeImpuestoAplicado(Double porcentajeImpuestoAplicado) {
        this.porcentajeImpuestoAplicado = porcentajeImpuestoAplicado;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
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
