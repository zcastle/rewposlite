package com.ob.controller;

import com.ob.model.Atencion;
import com.ob.model.Cliente;
import com.ob.model.Producto;
import com.ob.model.Usuario;
import com.ob.util.Record;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AtencionController extends Controller {

    public AtencionController(Connection conn) {
        super(conn);
    }

    public List<Atencion> getAtencion(int numero) throws SQLException {
        List<Atencion> atencion = new ArrayList<>();
        Atencion a;
        Producto p;
        Statement stm = this.conn.createStatement();
        ResultSet rs = stm.executeQuery("SELECT id, caja_id, nroatencion, cajero_id, cliente_id, producto_id, producto_name, cantidad, precio FROM atenciones WHERE nroatencion = " + numero + " ORDER BY id");
        while (rs.next()) {
            a = new Atencion();
            a.setId(rs.getInt("id"));
            a.setCajaId(rs.getInt("caja_id"));
            a.setNroAtencion(rs.getInt("nroatencion"));
            Usuario cajero = new UsuarioController(this.conn).getById(rs.getInt("cajero_id"));
            a.setCajero(cajero);
            Cliente cliente = new ClienteController(this.conn).getById(rs.getInt("cliente_id"));
            a.setCliente(cliente);

            p = new Producto(rs.getInt("producto_id"), rs.getString("producto_name"), rs.getDouble("precio"));
            p.setCantidad(rs.getDouble("cantidad"));
            a.setProducto(p);
            atencion.add(a);
        }
        return atencion;
    }

    public int addAtencion(Atencion a) throws SQLException {
        PreparedStatement pstm = this.conn.prepareStatement("INSERT INTO atenciones (caja_id, fechahora, nroatencion, cajero_id, producto_id, producto_name, cantidad, precio, cliente_id) VALUES(?, NOW(), ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
        pstm.setInt(1, a.getCajaId());
        pstm.setInt(2, a.getNroAtencion());
        pstm.setInt(3, a.getCajero().getId());
        pstm.setInt(4, a.getProducto().getId());
        pstm.setString(5, a.getProducto().getNombre());
        pstm.setDouble(6, a.getProducto().getCantidad());
        pstm.setDouble(7, a.getProducto().getPrecio());
        pstm.setInt(8, a.getCliente().getId());
        pstm.executeUpdate();
        ResultSet rs = pstm.getGeneratedKeys();
        int last_inserted_id = 0;
        if (rs.next()) {
            last_inserted_id = rs.getInt(1);
        }
        return last_inserted_id;
    }

    public void editAtencion(Atencion a) throws SQLException {
        PreparedStatement pstm = this.conn.prepareStatement("UPDATE atenciones SET producto_name = ?, cantidad = ?, precio = ? WHERE id = ?");
        pstm.setString(1, a.getProducto().getNombre());
        pstm.setDouble(2, a.getProducto().getCantidad());
        pstm.setDouble(3, a.getProducto().getPrecio());
        pstm.setInt(4, a.getId());
        pstm.execute();
    }
    
    public void eliminarAtencion(Atencion a) throws SQLException {
        PreparedStatement pstm = this.conn.prepareStatement("DELETE FROM atenciones WHERE id = ?");
        pstm.setInt(1, a.getId());
        pstm.execute();
    }
    
    public List<Record> getMonitor() throws SQLException {
        List<Record> monitor = new ArrayList<>();
        Atencion a;
        Producto p;
        Statement stm = this.conn.createStatement();
        ResultSet rs = stm.executeQuery("SELECT DISTINCT IFNULL(A.nroatencion, 0) estado, AC.id FROM atenciones_c AC LEFT JOIN atenciones A ON AC.id=A.nroatencion ORDER BY AC.id LIMIT 20;");
        while (rs.next()) {
            monitor.add(new Record(rs.getObject("id"), rs.getObject("estado").equals("0")));
        }
        return monitor;
    }
    
}
