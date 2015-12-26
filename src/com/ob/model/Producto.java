package com.ob.model;

/**
 *
 * @author jc
 */
public class Producto {

    public static final int UNIDAD_MAYOR = 0;
    public static final int UNIDAD_MENOR = 1;
    
    private int id;
    private int ln;
    private String codigo = "";
    private String nombre;
    private Double precio = 0.0;
    private String categoria = "";
    private int unidadId;
    private String unidad;
    private Double cantidad = 1.0;
    private int unidaType = UNIDAD_MAYOR;
    private Double Stock;

    public Producto() {
    }

    public Producto(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLn() {
        return ln;
    }

    public void setLn(int ln) {
        this.ln = ln;
    }
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getUnidadId() {
        return unidadId;
    }

    public void setUnidadId(int unidadId) {
        this.unidadId = unidadId;
    }
    
    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public int getUnidaType() {
        return unidaType;
    }

    public void setUnidaType(int unidaType) {
        this.unidaType = unidaType;
    }

    public Double getStock() {
        return Stock;
    }

    public void setStock(Double Stock) {
        this.Stock = Stock;
    }
    
}
