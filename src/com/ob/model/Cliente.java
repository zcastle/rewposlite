package com.ob.model;

public class Cliente {
    
    private int id = 0;
    private String ruc;
    private String razonSocial;
    private String Direccion;
    private Ubigeo ubigeo;

    public Cliente() {
    }
    
    public Cliente(int id, String ruc, String razonSocial) {
        this.id = id;
        this.ruc = ruc;
        this.razonSocial = razonSocial;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public Ubigeo getUbigeo() {
        return ubigeo;
    }

    public void setUbigeo(Ubigeo ubigeo) {
        this.ubigeo = ubigeo;
    }
    
}
