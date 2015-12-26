package com.ob.controller;

import com.ob.model.Categoria;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoriaController extends Controller {

    public CategoriaController(Connection conn) {
        super(conn);
    }

    public List<Categoria> getCategorias() throws SQLException {
        List<Categoria> categorias = new ArrayList<>();
        Statement stm = this.conn.createStatement();
        ResultSet rs = stm.executeQuery("SELECT id, nombre FROM categoria WHERE eliminado = 'N' ORDER BY orden");
        while (rs.next()) {
            categorias.add(new Categoria(rs.getInt("id"), rs.getString("nombre")));
        }
        return categorias;
    }

    /*public Categoria getCategoriaById(int id) {
        Categoria categoria = null;
        for (Categoria obj : getCategorias()) {
            if (obj.getId() == id) {
                categoria = obj;
                break;
            }
        }
        return categoria;
    }

    public Categoria getCategoriaByCodigo(String codigo) {
        Categoria categoria = null;
        for (Categoria obj : getCategorias()) {
            if (obj.getCodigo().equals(codigo)) {
                categoria = obj;
                break;
            }
        }
        return categoria;
    }*/

}
