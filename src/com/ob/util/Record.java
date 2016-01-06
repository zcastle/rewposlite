package com.ob.util;

public class Record {

    private Object clave;
    private Object valor;

    public Record(Object clave, Object valor) {
        this.clave = clave;
        this.valor = valor;
    }

    public Object getClave() {
        return clave;
    }

    public Object getValor() {
        return valor;
    }
    
}
