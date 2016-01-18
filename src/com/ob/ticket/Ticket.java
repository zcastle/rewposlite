package com.ob.ticket;

import java.util.List;

abstract class Ticket {
    protected String printer;
    protected Cabecera cabecera;
    protected List<Detalle> detalle;

    public Ticket(String printer, Cabecera cabecera, List<Detalle> detalle) {
        this.printer = printer;
        this.cabecera = cabecera;
        this.detalle = detalle;
    }
}
