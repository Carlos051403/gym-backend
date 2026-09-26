package com.portfolio.gym.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "compra")
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compra")
    private Integer idCompra;

    //hay que usar la libreria java.time para las fechas en este caso se declara como LocalDateTime
    @Column(name = "fecha_compra")
    private LocalDateTime fechaCompra;

    @Column(name = "numero_factura_externa")
    private String numeroFacturaExterna;

    @ManyToOne
    @JoinColumn(name = "id_proveedor_fk")
    private Proveedor proveedor;

    //Auditoría: Cuándo se insertó por primera vez (updatable = false evita que se modifique después)
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    //Auditoría: Cuándo fue la última modificación
    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public Compra() {
    }

    public Compra(LocalDateTime fechaCompra, String numeroFacturaExterna, Proveedor proveedor) {
        this.fechaCompra = fechaCompra;
        this.numeroFacturaExterna = numeroFacturaExterna;
        this.proveedor = proveedor;
    }

    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public LocalDateTime getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDateTime fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public String getNumeroFacturaExterna() {
        return numeroFacturaExterna;
    }

    public void setNumeroFacturaExterna(String numeroFacturaExterna) {
        this.numeroFacturaExterna = numeroFacturaExterna;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
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
