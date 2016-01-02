package com.ob.controller;

import com.ob.model.Categoria;
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

    public List<Usuario> getUsuarios(int rol) throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
        PreparedStatement pstm = this.conn.prepareStatement("SELECT id, CONCAT(nombre, ' ', apellido) AS nombre, sexo FROM usuario WHERE rol_id = ?");
        pstm.setInt(1, rol);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            usuarios.add(new Usuario(rs.getInt("id"), rs.getString("nombre"), rs.getString("sexo")));
        }
        return usuarios;
    }

    public boolean isLogin(Usuario usuario, String clave) throws SQLException {
        PreparedStatement pstm = this.conn.prepareStatement("SELECT * FROM usuario WHERE id = ? AND clave = ?");
        pstm.setInt(1, usuario.getId());
        pstm.setString(2, Util.getMD5(clave));
        return pstm.executeQuery().next();
    }

}