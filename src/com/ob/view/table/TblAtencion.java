package com.ob.view.table;

import com.ob.controller.AtencionController;
import com.ob.model.Atencion;
import com.ob.util.Conn;
import com.ob.util.Util;
import com.ob.view.panel.PnlAtencion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class TblAtencion extends TblBase {

    private List<Atencion> atenciones = null;

    public TblAtencion() {
        atenciones = new ArrayList<>();
        dtm = new DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "atencion_id", "producto_id", "Producto", "Cant.", "Precio", "Total"
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
        super.setModel(dtm);
        super.setWidthColumn(0, 0); //id
        super.setWidthColumn(1, 0); //producto_id
        super.setWidthColumn(3, 50); //Cantidad
        super.setWidthColumn(4, 60); //Precio
        super.setWidthColumn(5, 70); //Total

        DecimalFormatRenderer rightRenderer = new DecimalFormatRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
        super.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
        super.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
        super.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);

        super.setGridColor(new java.awt.Color(222, 222, 222));
        super.setRowHeight(40);
        super.setSelectionBackground(new java.awt.Color(0, 107, 182));
        super.setSelectionForeground(new java.awt.Color(254, 254, 254));
        super.setShowVerticalLines(false);
        super.getTableHeader().setReorderingAllowed(false);
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

    public Atencion getSelected() {
        int row = getSelectedRow();
        int id = (int) dtm.getValueAt(row, 0);
        for (Atencion a : this.atenciones) {
            if (a.getId() == id) {
                return a;
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
            if (a.getId() == 0) {
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
            updatecountItems();
            if (!isLoad) {
                this.atenciones.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TblAtencion.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(TblAtencion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarProducto(Atencion a) {
        for (int i = 0; i < dtm.getRowCount(); i++) {
            int id = (int) dtm.getValueAt(i, 0);
            if (id == a.getId()) {
                dtm.removeRow(i);
                updatecountItems();
                try {
                    new AtencionController(Conn.getConnection()).eliminarAtencion(a);
                } catch (SQLException ex) {
                    Logger.getLogger(TblAtencion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    private void updatecountItems() {
        Util.i("TOTAL ITEMS: "+dtm.getRowCount());
        PnlAtencion.getLblCount().setText(dtm.getRowCount()+"");
    }
}
