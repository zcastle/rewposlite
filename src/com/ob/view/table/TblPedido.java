package com.ob.view.table;

import javax.swing.table.DefaultTableModel;

public class TblPedido extends TblBase {
    
    public TblPedido() {
        dtm = new DefaultTableModel(
                new Object[][]{},
                new String [] {
                    "id", "Producto", "Precio", "Cantidad", "Total"
                }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            @Override
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        };
        this.setModel(dtm);
        this.setWidthColumn(this, 0, 0); //Id
        this.setWidthColumn(this, 2, 60); //Precio
        this.setWidthColumn(this, 3, 60); //Cantidad
        this.setWidthColumn(this, 4, 60); //Total
        
        this.setGridColor(new java.awt.Color(222, 222, 222));
        this.setRowHeight(40);
        this.setSelectionBackground(new java.awt.Color(0, 107, 182));
        this.setSelectionForeground(new java.awt.Color(254, 254, 254));
        this.setShowVerticalLines(false);
        this.getTableHeader().setReorderingAllowed(false);
    }
    
}
