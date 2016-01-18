/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ob.ticket;

/**
 *
 * @author ADMIN
 */
public class Detalle {
    private int atencionId;
    private Double cantidad;
    private String producto;
    private Double unitario;
    private String mensaje;

    public Detalle() {
    }

    public Detalle(Double cantidad, String producto, Double unitario) {
        this.cantidad = cantidad;
        this.producto = producto;
        this.unitario = unitario;
    }
    
    public Detalle(Double cantidad, int atencionId, String producto, String mensaje) {
        this.cantidad = cantidad;
        this.atencionId = atencionId;
        this.producto = producto;
        this.mensaje = mensaje;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public int getAtencionId() {
        return atencionId;
    }

    public String getProducto() {
        return producto;
    }

    public Double getUnitario() {
        return unitario;
    }

    public String getMensaje() {
        return mensaje;
    }
    
    public Double getTotal() {
        return cantidad*unitario;
    }
}
