package com.ob.model;

public class Categoria {

    private int id;
    private String codigo;
    private String nombre;

    public Categoria(int id, String nombre) {
        super();
        this.id = id;
        this.nombre = nombre.toUpperCase();
    }

    public Categoria(String codigo, String nombre) {
        super();
        this.codigo = codigo;
        this.nombre = nombre.toUpperCase();
    }
    
    public Categoria(int id, String codigo, String nombre) {
        super();
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre.toUpperCase();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return this.nombre;
    }

}
