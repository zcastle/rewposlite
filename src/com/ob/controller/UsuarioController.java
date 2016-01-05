package com.ob.controller;

import com.ob.model.Usuario;
import com.ob.util.Util;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsuarioController extends Controller {

    public static final int ROL_CAJERO = 2;
    public static final int ROL_MOZO = 6;
    public static final int ROL_ADMIN = 1;

    public UsuarioController(Connection conn) {
        super(conn);
    }

    public List<Usuario> getAll(int rol) throws SQLException {
        List<Usuario> u = new ArrayList<>();
        PreparedStatement pstm = this.conn.prepareStatement("SELECT id, CONCAT(nombre, ' ', apellido) AS nombre, sexo FROM usuario WHERE rol_id = ?");
        pstm.setInt(1, rol);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            u.add(new Usuario(rs.getInt("id"), rs.getString("nombre"), rs.getString("sexo")));
        }
        return u;
    }
    
    public Usuario getById(int id) throws SQLException {
        Usuario u = null;
        Statement stm = this.conn.createStatement();
        ResultSet rs = stm.executeQuery("SELECT id, CONCAT(nombre, ' ', apellido) AS nombre, sexo FROM usuario WHERE id = "+id);
        if (rs.next()) {
            u = new Usuario(rs.getInt("id"), rs.getString("nombre"), rs.getString("sexo"));
        }
        return u;
    }

    public boolean isLogin(Usuario u, String clave) throws SQLException {
        PreparedStatement pstm = this.conn.prepareStatement("SELECT * FROM usuario WHERE id = ? AND clave = ?");
        pstm.setInt(1, u.getId());
        pstm.setString(2, Util.getMD5(clave));
        return pstm.executeQuery().next();
    }

}