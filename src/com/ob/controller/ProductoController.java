package com.ob.controller;

import com.ob.model.Producto;
import com.ob.util.App;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductoController extends Controller {

    //private List<Producto> productos = null;
    
    public ProductoController(Connection conn) {
        super(conn);
    }

    public List<Producto> getProductos() throws SQLException {
        return ProductoController.this.getProductos(App.DEFAULT_LIMIT);
    }

    public List<Producto> getProductos(int limit) throws SQLException {
        List<Producto> p = new ArrayList<>();
        Statement stm = this.conn.createStatement();
        ResultSet rs = stm.executeQuery("SELECT id, nombre, precio FROM producto ORDER BY orden, nombre, precio LIMIT "+limit);
        while (rs.next()) {
            p.add(new Producto(rs.getInt("id"), rs.getString("nombre"), rs.getDouble("precio")));
        }
        return p;
    }

    public List<Producto> getProductos(String nombre) throws SQLException {
        return getProductos(nombre, App.DEFAULT_LIMIT);
    }

    public List<Producto> getProductos(String nombre, int limit) throws SQLException {
        List<Producto> p = new ArrayList<>();
        PreparedStatement pstm = this.conn.prepareStatement("SELECT id, nombre, precio FROM producto WHERE nombre LIKE ? ORDER BY orden, nombre, precio LIMIT "+limit);
        pstm.setString(1, "%".concat(nombre).concat("%"));
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            p.add(new Producto(rs.getInt("id"), rs.getString("nombre"), rs.getDouble("precio")));
        }
        return p;
    }

    /*public Producto getProductoById(int id) throws IOException {
        Producto producto = data.getProducto(id);
        return producto;
    }*/

}
