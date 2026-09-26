package com.portfolio.gym.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "venta")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venta")
    private Integer idVenta;

    @Column(name = "fecha_venta")
    private LocalDateTime fechaVenta;

    @Column(name = "canal_venta")
    private String canalVenta;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado_venta")
    private EstadoVenta estadoVenta;

    @Enumerated(EnumType.STRING)
    @Column(name = "metodo_pago")
    private MetodoPago metodoPago;

    @Column(name = "numero_factura_interna")
    private String numeroFacturaInterna;

    @ManyToOne
    @JoinColumn(name = "id_cliente_fk")
    private Usuario cliente;

    @ManyToOne
    @JoinColumn(name = "id_empleado_fk")
    private Usuario empleado;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public Venta() {
    }

    public Venta(LocalDateTime fechaVenta, String canalVenta, EstadoVenta estadoVenta,
                 MetodoPago metodoPago, String numeroFacturaInterna, Usuario cliente, Usuario empleado) {
        this.fechaVenta = fechaVenta;
        this.canalVenta = canalVenta;
        this.estadoVenta = estadoVenta;
        this.metodoPago = metodoPago;
        this.numeroFacturaInterna = numeroFacturaInterna;
        this.cliente = cliente;
        this.empleado = empleado;
    }

    public Integer getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public LocalDateTime getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(LocalDateTime fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public String getCanalVenta() {
        return canalVenta;
    }

    public void setCanalVenta(String canalVenta) {
        this.canalVenta = canalVenta;
    }

    public EstadoVenta getEstadoVenta() {
        return estadoVenta;
    }

    public void setEstadoVenta(EstadoVenta estadoVenta) {
        this.estadoVenta = estadoVenta;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public String getNumeroFacturaInterna() {
        return numeroFacturaInterna;
    }

    public void setNumeroFacturaInterna(String numeroFacturaInterna) {
        this.numeroFacturaInterna = numeroFacturaInterna;
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    public Usuario getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Usuario empleado) {
        this.empleado = empleado;
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
