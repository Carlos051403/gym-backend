package com.portfolio.gym.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "suplemento")
public class Suplemento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_suplemento")
    private Integer idSuplemento;

    @Column(name = "codigo_barras")
    private String codigoBarras;

    @Column(name = "sku_interno")
    private String skuInterno;

    @Column(name = "nombre_suplemento")
    private String nombreSuplemento;

    @Column(name = "descripcion_suplemento")
    private String descripcionSuplemento;

    @Column(name = "precio_venta_actual")
    private Double precioVentaActual;

    @Column(name = "stock_actual")
    private Integer stockActual;

    @Column(name = "stock_minimo")
    private Integer stockMinimo;

    @Column(name = "stock_maximo")
    private Integer stockMaximo;

    @Column(name = "url_imagen")
    private String urlImagen;

    @ManyToOne
    @JoinColumn(name = "id_categoria_fk")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "id_marca_fabricante_fk")
    private MarcaFabricante marcaFabricante;

    @ManyToOne
    @JoinColumn(name = "id_ïmpuesto_fk")
    private Impuesto impuesto;

    public Suplemento() {
    }

    public Suplemento(String codigoBarras, String skuInterno, String nombreSuplemento, String descripcionSuplemento,
                      Double precioVentaActual, Integer stockActual, Integer stockMinimo, Integer stockMaximo, String urlImagen,
                      Categoria categoria, MarcaFabricante marcaFabricante, Impuesto impuesto) {
        this.codigoBarras = codigoBarras;
        this.skuInterno = skuInterno;
        this.nombreSuplemento = nombreSuplemento;
        this.descripcionSuplemento = descripcionSuplemento;
        this.precioVentaActual = precioVentaActual;
        this.stockActual = stockActual;
        this.stockMinimo = stockMinimo;
        this.stockMaximo = stockMaximo;
        this.urlImagen = urlImagen;
        this.categoria = categoria;
        this.marcaFabricante = marcaFabricante;
        this.impuesto = impuesto;
    }

    public Integer getIdSuplemento() {
        return idSuplemento;
    }

    public void setIdSuplemento(Integer idSuplemento) {
        this.idSuplemento = idSuplemento;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getSkuInterno() {
        return skuInterno;
    }

    public void setSkuInterno(String skuInterno) {
        this.skuInterno = skuInterno;
    }

    public String getNombreSuplemento() {
        return nombreSuplemento;
    }

    public void setNombreSuplemento(String nombreSuplemento) {
        this.nombreSuplemento = nombreSuplemento;
    }

    public String getDescripcionSuplemento() {
        return descripcionSuplemento;
    }

    public void setDescripcionSuplemento(String descripcionSuplemento) {
        this.descripcionSuplemento = descripcionSuplemento;
    }

    public Double getPrecioVentaActual() {
        return precioVentaActual;
    }

    public void setPrecioVentaActual(Double precioVentaActual) {
        this.precioVentaActual = precioVentaActual;
    }

    public Integer getStockActual() {
        return stockActual;
    }

    public void setStockActual(Integer stockActual) {
        this.stockActual = stockActual;
    }

    public Integer getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(Integer stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    public Integer getStockMaximo() {
        return stockMaximo;
    }

    public void setStockMaximo(Integer stockMaximo) {
        this.stockMaximo = stockMaximo;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public MarcaFabricante getMarcaFabricante() {
        return marcaFabricante;
    }

    public void setMarcaFabricante(MarcaFabricante marcaFabricante) {
        this.marcaFabricante = marcaFabricante;
    }

    public Impuesto getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(Impuesto impuesto) {
        this.impuesto = impuesto;
    }
}
