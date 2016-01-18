package com.ob.ticket;

import java.util.Date;

public class Venta {

    private int id;
    private int dia;
    private Date fechaHora;
    private String pax;
    private int mozoId;
    private int cajeroId;
    private int clienteId;
    private int cajaId;
    private int tipoDocumentoId;
    private String serie;
    private String numero;
    private Double total;
    private int anuladoId;
    
    public Venta() {}

    public int getId() {
        return id;
    }

    public int getDia() {
        return dia;
    }
    
    public Date getFechaHora() {
        return fechaHora;
    }

    public String getPax() {
        return pax;
    }

    public int getMozoId() {
        return mozoId;
    }

    public int getCajeroId() {
        return cajeroId;
    }

    public int getClienteId() {
        return clienteId;
    }

    public int getCajaId() {
        return cajaId;
    }

    public int getTipoDocumentoId() {
        return tipoDocumentoId;
    }

    public String getSerie() {
        return serie;
    }

    public String getNumero() {
        return numero;
    }

    public Double getTotal() {
        return total;
    }

    public int getAnuladoId() {
        return anuladoId;
    }
}
