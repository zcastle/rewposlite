package com.ob.model;

import java.util.List;

public class Provincia {
    
    private int id;
    private String nombre;
    private Departamento departamento;
    private List<Ubigeo> ubigeo;

    public Provincia() {
    }

    public Provincia(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public List<Ubigeo> getUbigeo() {
        return ubigeo;
    }

    public void setUbigeo(List<Ubigeo> ubigeo) {
        this.ubigeo = ubigeo;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
