package com.ob.model;

public class Usuario {

    private int id;
    private String nombre;
    private String sexo = "M";
    //private String clave;

    public Usuario() {
        super();
    }

    public Usuario(int id, String nombre, String sexo) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.sexo = sexo;
    }

    /*public Usuario(int id, String nombre, String clave) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.clave = clave;
    }*/

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

    /*public String getClave() {
    return clave;
    }
    public void setClave(String clave) {
    this.clave = clave;
    }*/
    /*public boolean isLogin(String clave) throws NoSuchAlgorithmException {
    return getClave().equals(Util.getMD5(clave));
    }*/
    
    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    @Override
    public String toString() {
        return this.nombre;
    }
}
