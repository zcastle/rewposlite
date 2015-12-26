package com.ob.controller;

import com.ob.model.Caja;
import com.ob.model.CentroCosto;
import com.ob.model.Cia;
import com.ob.util.Util;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CiaController extends Controller {

    public CiaController(Connection conn) {
        super(conn);
    }

    public Cia getCia() throws SQLException {
        Cia cia = new Cia();
        CentroCosto centroCosto = new CentroCosto();
        Caja caja = new Caja();
        
        Statement stmCia = this.conn.createStatement();
        ResultSet rsCia = stmCia.executeQuery("SELECT E.id, E.ruc, E.razon_social, E.nombre_comercial, CONCAT(E.direccion, ' ', U.nombre) AS direccion, E.telefono \n" +
            "FROM empresa E INNER JOIN ubigeo U ON U.id=E.ubigeo_id WHERE E.codigo='01'");
        if (rsCia.next()) {
            int ciaId = rsCia.getInt("id");
            cia.setId(ciaId);
            cia.setRuc(rsCia.getString("ruc"));
            cia.setRazonSocial(rsCia.getString("razon_social"));
            cia.setNombreComercial(rsCia.getString("nombre_comercial"));
            cia.setDireccion(rsCia.getString("direccion"));
            cia.setTelefono(rsCia.getString("telefono"));
            
            Statement stmCentroCosto = this.conn.createStatement();
            ResultSet rsCentroCosto = stmCentroCosto.executeQuery("SELECT C.id, C.nombre, CONCAT(C.direccion, ' ', U.nombre) AS direccion, C.mensaje, C.servicio, C.tipocambio\n" +
                "FROM centrocosto C INNER JOIN ubigeo U ON U.id=C.ubigeo_id\n" +
                "WHERE C.empresa_id = "+ciaId+";");
            if(rsCentroCosto.next()){
                int centroCosto_id = rsCentroCosto.getInt("id");
                centroCosto.setId(centroCosto_id);
                centroCosto.setNombre(rsCentroCosto.getString("nombre"));
                centroCosto.setDireccion(rsCentroCosto.getString("direccion"));
                centroCosto.setMensaje(rsCentroCosto.getString("mensaje"));
                centroCosto.setServicio(rsCentroCosto.getDouble("servicio"));
                centroCosto.setTipoCambio(rsCentroCosto.getDouble("tipocambio"));
                
                Statement stmCaja = this.conn.createStatement();
                ResultSet rsCaja = stmCaja.executeQuery("SELECT id, nombre, impresora_p, impresora_b, impresora_f, impresora_x, impresora_z, dia, seriecaja, autorizacion\n" +
                    "FROM caja WHERE centrocosto_id = "+centroCosto_id+";");
                if(rsCaja.next()){
                    caja.setId(rsCaja.getInt("id"));
                    caja.setNombre(rsCaja.getString("nombre"));
                    caja.setImpresoraP(rsCaja.getString("impresora_p"));
                    caja.setImpresoraB(rsCaja.getString("impresora_b"));
                    caja.setImpresoraF(rsCaja.getString("impresora_f"));
                    caja.setImpresoraX(rsCaja.getString("impresora_x"));
                    caja.setImpresoraZ(rsCaja.getString("impresora_z"));
                    caja.setDia(rsCaja.getInt("dia"));
                    caja.setSerieCaja(rsCaja.getString("seriecaja"));
                    caja.setAutorizacion(rsCaja.getString("autorizacion"));
                }else{
                    Util.showMessageAndExit("No se ha registrado la Caja");
                }
                centroCosto.setCaja(caja);
            }else{
                Util.showMessageAndExit("No se ha registrado Centro de Costo");
            }
            cia.setCentroCosto(centroCosto);
        }else{
            Util.showMessageAndExit("No se ha registrado la Empresa");
        }
        return cia;
    }

}
