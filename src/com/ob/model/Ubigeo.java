package com.ob.model;

public class Ubigeo {
    
    private int id;
    private String nombre;
    private Provincia provincia;

    public Ubigeo() {
    }

    public Ubigeo(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
