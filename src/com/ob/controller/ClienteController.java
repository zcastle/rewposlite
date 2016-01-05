package com.ob.controller;

import com.ob.model.Cliente;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClienteController extends Controller {

    public ClienteController(Connection conn) {
        super(conn);
    }

    /*public List<Usuario> getAll(int rol) throws SQLException {
        List<Usuario> u = new ArrayList<>();
        PreparedStatement pstm = this.conn.prepareStatement("SELECT id, CONCAT(nombre, ' ', apellido) AS nombre, sexo FROM usuario WHERE rol_id = ?");
        pstm.setInt(1, rol);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            u.add(new Usuario(rs.getInt("id"), rs.getString("nombre"), rs.getString("sexo")));
        }
        return u;
    }*/
    
    public Cliente getById(int id) throws SQLException {
        Cliente u = new Cliente();
        Statement stm = this.conn.createStatement();
        ResultSet rs = stm.executeQuery("SELECT id, ruc, nombre, direccion, ubigeo_id FROM cliente");
        if (rs.next()) {
            u.setId(rs.getInt("id"));
            u.setRuc(rs.getString("ruc"));
            u.setRazonSocial(rs.getString("nombre"));
            u.setDireccion(rs.getString("direccion"));
            //u.setUbigeo(new Ubigeo());
        }
        return u;
    }

}