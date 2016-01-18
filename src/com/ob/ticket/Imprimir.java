package com.ob.ticket;

import com.ob.controller.AtencionController;
import com.ob.model.Atencion;
import com.ob.model.Caja;
import com.ob.model.CentroCosto;
import com.ob.model.Cia;
import com.ob.util.App;
import com.ob.util.Conn;
import com.ob.util.Util;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Imprimir {
    
    private Caja caja = null;
    private Cabecera cabecera = null;
    private Connection conn = null;
    
    public Imprimir(){
        this.caja = App.CIA.getCentroCosto().getCaja();
        this.cabecera = getCabecera();
        this.conn = Conn.getConnection();
    }
    
    private Cabecera getCabecera() {
        CentroCosto cc = App.CIA.getCentroCosto();
        Cia cia = App.CIA;
        Cabecera c = new Cabecera();
        c.setRazonSocial(cia.getRazonSocial());
        c.setNombreComercial(cia.getNombreComercial());
        c.setRuc(cia.getRuc());
        c.setDireccion(cia.getDireccion());
        c.setTelefono(cia.getTelefono());
        c.setAutorizacion(caja.getAutorizacion() == null ? "" : caja.getAutorizacion());
        c.setSerie(caja.getSerieCaja());
        c.setServicio(cc.getServicio());
        c.setTipoCambio(cc.getTipoCambio());
        c.setDespedida(cc.getMensaje());
        return c;
    }
    
    public boolean precuenta(int numero) {
        try {
            List<Atencion> atenciones = new AtencionController(this.conn).getAtencion(numero);
            if (atenciones.size() > 0) {
                Atencion atencion = atenciones.get(0);
                
                this.cabecera.setMesa(atencion.getNroAtencion());
               
                this.cabecera.setCajero(atencion.getCajero().getNombre());
                List<Detalle> lstDetalle = new ArrayList<>();
                for (Atencion fila : atenciones) {
                    lstDetalle.add(new Detalle(fila.getProducto().getCantidad(), fila.getProducto().getNombre(), fila.getProducto().getPrecio()));
                }
                boolean success = new Precuenta(this.caja.getImpresoraP(), this.cabecera, lstDetalle).print();
                if (success) {
                    Util.i("Print Precuenta OK [".concat(this.caja.getImpresoraP()).concat("]"));
                } else {
                    Util.i("Algun error en la Precuenta");
                }
                return success;
            } else {
                return true;
            }
        } catch (SQLException ex) {
            Util.i(ex.getMessage());
            return false;
        }
    }
}
