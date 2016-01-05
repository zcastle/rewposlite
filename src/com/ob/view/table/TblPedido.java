package com.ob.view.table;

import com.ob.controller.AtencionController;
import com.ob.model.Atencion;
import com.ob.model.Producto;
import com.ob.util.Conn;
import com.ob.util.Util;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class TblPedido extends TblBase {

    private List<Atencion> atenciones = null;

    public TblPedido() {
        atenciones = new ArrayList<>();
        dtm = new DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "atencion_id", "producto_id", "Producto", "Cantidad", "Precio", "Total"
                }
        ) {
            Class[] types = new Class[]{
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false
            };

            @Override
            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
        this.setModel(dtm);
        this.setWidthColumn(this, 0, 0); //id
        this.setWidthColumn(this, 1, 0); //producto_id
        this.setWidthColumn(this, 3, 60); //Precio
        this.setWidthColumn(this, 4, 60); //Cantidad
        this.setWidthColumn(this, 5, 60); //Total

        DecimalFormatRenderer rightRenderer = new DecimalFormatRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
        this.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
        this.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
        this.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);

        this.setGridColor(new java.awt.Color(222, 222, 222));
        this.setRowHeight(40);
        this.setSelectionBackground(new java.awt.Color(0, 107, 182));
        this.setSelectionForeground(new java.awt.Color(254, 254, 254));
        this.setShowVerticalLines(false);
        this.getTableHeader().setReorderingAllowed(false);
    }

    /*public Atencion getAtencion() {
        return atenciones;
    }*/
    
    public void setAtencion(List<Atencion> atenciones) {
        this.atenciones = atenciones;
        for (Atencion a : this.atenciones) {
            addProducto(a, true);
        }
    }

    public Atencion getAtencion(Atencion a) {
        for (Atencion atencion : this.atenciones) {
            if (atencion.getProducto().getId() == a.getProducto().getId()) {
                return atencion;
            }
        }
        return null;
    }

    public void addProducto(Atencion a) {
        Atencion current = getAtencion(a);
        if (current == null) {
            addProducto(a, false);
        } else {
            editProducto(current, "", current.getProducto().getCantidad() + 1, 0.0);
        }
    }

    public void addProducto(Atencion a, boolean isLoad) {
        try {
            if(a.getId()==0){
                int id = new AtencionController(Conn.getConnection()).addAtencion(a);
                Util.i(id);
                a.setId(id);
            }
            Object[] row = new Object[6];
            row[0] = a.getId();
            row[1] = a.getProducto().getId();
            row[2] = a.getProducto().getNombre();
            row[3] = a.getProducto().getCantidad();
            row[4] = a.getProducto().getPrecio();
            row[5] = a.getProducto().getTotal();
            dtm.addRow(row);
            if (!isLoad) {
                this.atenciones.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TblPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editProducto(Atencion a, String nombre, Double cantidad, Double precio) {
        if (!nombre.isEmpty()) {
            a.getProducto().setNombre(nombre);
        }
        if (cantidad > 0.0) {
            a.getProducto().setCantidad(cantidad);
        }
        if (precio > 0.0) {
            a.getProducto().setPrecio(precio);
        }
        int row = 0;// = getSelectedRow();
        for (int i = 0; i < dtm.getRowCount(); i++) {
            int id = (int) dtm.getValueAt(i, 1);
            if (id == a.getProducto().getId()) {
                row = i;
            }
        }
        dtm.setValueAt(a.getProducto().getNombre(), row, 2);
        dtm.setValueAt(a.getProducto().getCantidad(), row, 3);
        dtm.setValueAt(a.getProducto().getPrecio(), row, 4);
        dtm.setValueAt(a.getProducto().getTotal(), row, 5);
        try {
            new AtencionController(Conn.getConnection()).editAtencion(a);
        } catch (SQLException ex) {
            Logger.getLogger(TblPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void removeProducto(int atencionId) {
        for (int i = 0; i < dtm.getRowCount(); i++) {
            int id = (int) dtm.getValueAt(i, 0);
            Util.i(id);
        }
        //this.atencion.getProductos().add(producto);
    }
}
