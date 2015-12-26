package com.ob.model;

public class Caja {
    
    private int id;
    private String nombre;
    private String impresoraP;
    private String impresoraB;
    private String impresoraF;
    private String impresoraX;
    private String impresoraZ;
    private int dia;
    private String serieCaja;
    private String autorizacion;
    private Double igv;

    public Caja() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImpresoraP() {
        return impresoraP;
    }

    public void setImpresoraP(String impresoraP) {
        this.impresoraP = impresoraP;
    }

    public String getImpresoraB() {
        return impresoraB;
    }

    public void setImpresoraB(String impresoraB) {
        this.impresoraB = impresoraB;
    }

    public String getImpresoraF() {
        return impresoraF;
    }

    public void setImpresoraF(String impresoraF) {
        this.impresoraF = impresoraF;
    }

    public String getImpresoraX() {
        return impresoraX;
    }

    public void setImpresoraX(String impresoraX) {
        this.impresoraX = impresoraX;
    }

    public String getImpresoraZ() {
        return impresoraZ;
    }

    public void setImpresoraZ(String impresoraZ) {
        this.impresoraZ = impresoraZ;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public String getSerieCaja() {
        return serieCaja;
    }

    public void setSerieCaja(String serieCaja) {
        this.serieCaja = serieCaja;
    }

    public String getAutorizacion() {
        return autorizacion;
    }

    public void setAutorizacion(String autorizacion) {
        this.autorizacion = autorizacion;
    }

    public Double getIgv() {
        return igv;
    }

    public void setIgv(Double igv) {
        this.igv = igv;
    }
    
}
