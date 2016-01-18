package com.ob.model;

public class Atencion {

    private int id = 0;
    private int cajaId;
    private int nroAtencion;
    private Usuario cajero;
    private Cliente cliente;
    private Producto producto;

    public Atencion() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCajaId() {
        return cajaId;
    }

    public void setCajaId(int cajaId) {
        this.cajaId = cajaId;
    }

    public int getNroAtencion() {
        return nroAtencion;
    }

    public void setNroAtencion(int nroAtencion) {
        this.nroAtencion = nroAtencion;
    }

    public Usuario getCajero() {
        return cajero;
    }

    public void setCajero(Usuario cajero) {
        this.cajero = cajero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}