package com.ob.controller;

import com.ob.model.Producto;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class ProductoController extends Controller {

    //private List<Producto> productos = null;
    
    public ProductoController(Connection conn) {
        super(conn);
        //productos = data.getProductos();
    }

    /*public List<Producto> getProductos() throws IOException {
        return data.getProductos();
    }

    public List<Producto> getProductos(int lenght) throws IOException {
        List<Producto> productos = data.getProductos();
        List<Producto> p = new ArrayList<>();
        for (int i = 0; i < lenght; i++) {
            p.add(productos.get(i));
        }
        return p;
    }

    public List<Producto> getProductoContainName(String nombre) throws IOException {
        return data.getProductos(nombre);
    }

    public List<Producto> getProductoContainName(String nombre, int limit) throws IOException {
        List<Producto> productos = data.getProductos();
        ArrayList<Producto> p = new ArrayList<>();
        int ini = 0;
        for (Producto obj : productos) {
            if (obj.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
                ini += 1;
                p.add(obj);
                if (ini == limit) {
                    break;
                }
            }
        }
        return p;
    }

    public Producto getProductoById(int id) throws IOException {
        Producto producto = data.getProducto(id);
        return producto;
    }*/

}
