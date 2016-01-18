package com.ob.model;

import java.util.List;

public class Departamento {
    
    private int id;
    private String nombre;
    private List<Provincia> provincias;

    public Departamento() {
    }

    public Departamento(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setProvincias(List<Provincia> provincias) {
        this.provincias = provincias;
    }

    public List<Provincia> getProvincias() {
        return provincias;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
