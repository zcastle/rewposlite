package com.ob.model;

public class Atencion {

    private int id;
    private int cajaId;
    private String fechaHora;
    private int nroAtencion;
    private int cajeroId;
    private int productoId;
    private String productoName;
    private Double cantidad;
    private Double precio;
    private int clienteId;

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

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public int getNroAtencion() {
        return nroAtencion;
    }

    public void setNroAtencion(int nroAtencion) {
        this.nroAtencion = nroAtencion;
    }

    public int getCajeroId() {
        return cajeroId;
    }

    public void setCajeroId(int cajeroId) {
        this.cajeroId = cajeroId;
    }

    public int getProductoId() {
        return productoId;
    }

    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }

    public String getProductoName() {
        return productoName;
    }

    public void setProductoName(String productoName) {
        this.productoName = productoName;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }
    
}
