package com.ob.model;

/**
 *
 * @author jc
 */
public class Producto {
    
    private int id;
    //private int ln;
    //private int atencionId; //no necesario?
    //private String codigo = ""; //no necesario?
    private String nombre;
    private Double precio = 0.0;
    private Double cantidad = 1.0;

    public Producto() {
    }

    public Producto(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    
    public Producto(int id, String nombre, Double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /*public int getLn() {
        return ln;
    }

    public void setLn(int ln) {
        this.ln = ln;
    }*/
    
    /*public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }*/

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

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Object getTotal() {
        return this.cantidad*this.precio;
    }
}
