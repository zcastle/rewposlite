package com.ob.view.table;

import javax.swing.table.DefaultTableModel;

public class TblProducto extends TblBase {
    
    public TblProducto() {
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
        this.setModel(dtm);
        this.setWidthColumn(this, 0, 0); //Id
        this.setWidthColumn(this, 2, 60); //Precio
    }
    
}
