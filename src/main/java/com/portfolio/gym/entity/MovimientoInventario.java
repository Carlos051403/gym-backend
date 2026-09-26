package com.portfolio.gym.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "movimiento_inventario")
public class MovimientoInventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_movimiento_inventario")
    private Integer idMovimientoInventario;

    @Column(name = "fecha_movimiento")
    private LocalDateTime fechaMovimiento;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_movimiento")
    private TipoMovimiento tipoMovimiento;

    @Column(name = "cantidad_movimiento")
    private Integer cantidadMovimiento;

    @ManyToOne
    @JoinColumn(name = "id_suplemento_fk")
    private Suplemento suplemento;

    @ManyToOne
    @JoinColumn(name = "id_detalle_compra_fk")
    private DetalleCompra detalleCompra;

    @ManyToOne
    @JoinColumn(name = "id_detalle_venta_fk")
    private DetalleVenta detalleVenta;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public MovimientoInventario() {
    }

    public MovimientoInventario(LocalDateTime fechaMovimiento, TipoMovimiento tipoMovimiento,
                                Integer cantidadMovimiento, Suplemento suplemento, DetalleCompra detalleCompra,
                                DetalleVenta detalleVenta) {
        this.fechaMovimiento = fechaMovimiento;
        this.tipoMovimiento = tipoMovimiento;
        this.cantidadMovimiento = cantidadMovimiento;
        this.suplemento = suplemento;
        this.detalleCompra = detalleCompra;
        this.detalleVenta = detalleVenta;
    }

    public Integer getIdMovimientoInventario() {
        return idMovimientoInventario;
    }

    public void setIdMovimientoInventario(Integer idMovimientoInventario) {
        this.idMovimientoInventario = idMovimientoInventario;
    }

    public LocalDateTime getFechaMovimiento() {
        return fechaMovimiento;
    }

    public void setFechaMovimiento(LocalDateTime fechaMovimiento) {
        this.fechaMovimiento = fechaMovimiento;
    }

    public TipoMovimiento getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(TipoMovimiento tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public Integer getCantidadMovimiento() {
        return cantidadMovimiento;
    }

    public void setCantidadMovimiento(Integer cantidadMovimiento) {
        this.cantidadMovimiento = cantidadMovimiento;
    }

    public Suplemento getSuplemento() {
        return suplemento;
    }

    public void setSuplemento(Suplemento suplemento) {
        this.suplemento = suplemento;
    }

    public DetalleCompra getDetalleCompra() {
        return detalleCompra;
    }

    public void setDetalleCompra(DetalleCompra detalleCompra) {
        this.detalleCompra = detalleCompra;
    }

    public DetalleVenta getDetalleVenta() {
        return detalleVenta;
    }

    public void setDetalleVenta(DetalleVenta detalleVenta) {
        this.detalleVenta = detalleVenta;
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
