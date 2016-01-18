package com.ob.controller;

import com.ob.model.Cliente;
import com.ob.model.Departamento;
import com.ob.model.Provincia;
import com.ob.model.Ubigeo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClienteController extends Controller {

    public ClienteController(Connection conn) {
        super(conn);
    }

    public Cliente getById(int id) throws SQLException {
        Cliente cliente = new Cliente();
        Statement stm = this.conn.createStatement();
        ResultSet rs = stm.executeQuery("SELECT C.id, C.ruc, C.nombre, C.direccion, C.ubigeo_id, U1.nombre AS ubigeo_nombre,\n" +
            "U2.id AS provincia_id, U2.nombre AS provincia_nombre, U3.id AS departamento_id, U3.nombre  AS departamento_nombre\n" +
            "FROM cliente C INNER JOIN ubigeo U1 ON U1.id=C.ubigeo_id\n" +
            "INNER JOIN ubigeo U2 ON U2.co_departamento=U1.co_departamento AND U2.co_provincia=U1.co_provincia AND U2.co_distrito='00'\n" +
            "INNER JOIN ubigeo U3 ON U3.co_departamento=U2.co_departamento AND U3.co_provincia='00' AND U3.co_distrito='00'\n" +
            "WHERE C.id = "+id);
        if (rs.next()) {
            cliente.setId(rs.getInt("id"));
            cliente.setRuc(rs.getString("ruc"));
            cliente.setRazonSocial(rs.getString("nombre"));
            cliente.setDireccion(rs.getString("direccion"));
            //Departamento dep = new Departamento(rs.getInt("departamento_id"), rs.getString("departamento_nombre"));
            Provincia pro = new Provincia(rs.getInt("provincia_id"), rs.getString("provincia_nombre"));
            pro.setDepartamento(new Departamento(rs.getInt("departamento_id"), rs.getString("departamento_nombre")));
            Ubigeo ubigeo = new Ubigeo(rs.getInt("ubigeo_id"), rs.getString("ubigeo_nombre"));
            ubigeo.setProvincia(pro);
            cliente.setUbigeo(ubigeo);
            return cliente;
        }
        return new Cliente();
    }
    
    public Cliente getByRuc(String ruc) throws SQLException {
        Statement stm = this.conn.createStatement();
        ResultSet rs = stm.executeQuery("SELECT id FROM cliente WHERE ruc = '"+ruc+"'");
        if (rs.next()) {
            return getById(rs.getInt("id"));
        }
        return new Cliente();
    }

}