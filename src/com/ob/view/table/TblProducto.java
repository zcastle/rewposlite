package com.ob.view.table;

import com.ob.model.Producto;
import java.util.ArrayList;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class TblProducto extends TblBase {

    private ArrayList<Producto> productos;

    public TblProducto() {
        productos = new ArrayList<>();
        dtm = new DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "id", "Producto", "Precio"
                }
        ) {
            Class[] types = new Class[]{
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean[]{
                false, false, false
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
        DecimalFormatRenderer rightRenderer = new DecimalFormatRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
        super.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
        super.setWidthColumn(0, 0); //Id
        super.setWidthColumn(2, 60); //Precio
    }

    public void removeProductos() {
        productos = new ArrayList<>();
        dtm.setRowCount(0);
    }

    public void addProducto(Producto p) {
        Object[] row = new Object[3];
        row[0] = p.getId();
        row[1] = p.getNombre();
        row[2] = p.getPrecio();
        dtm.addRow(row);
        this.productos.add(p);
    }

    public Producto getSelected() {
        int row = getSelectedRow();
        int id = (int) dtm.getValueAt(row, 0);
        for (Producto p : this.productos) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }
}
