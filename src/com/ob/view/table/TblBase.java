package com.ob.view.table;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public abstract class TblBase extends JTable {

    protected DefaultTableModel dtm;

    public TblBase() {
        super();
        setFont(new java.awt.Font("", 0, 14));
        setGridColor(new java.awt.Color(222, 222, 222));
        setRowHeight(30);
        setSelectionBackground(new java.awt.Color(0, 107, 182));
        setSelectionForeground(new java.awt.Color(255, 255, 255));
        setShowVerticalLines(false);
        //setTableHeader(null);
    }

    public void setWidthColumn(JTable table, int col, int width) {
        table.getColumnModel().getColumn(col).setMinWidth(width);
        table.getColumnModel().getColumn(col).setPreferredWidth(width);
        table.getColumnModel().getColumn(col).setMaxWidth(width);
        table.getColumnModel().getColumn(col).setWidth(width);
    }

    public DefaultTableModel getDtm() {
        return dtm;
    }
}
