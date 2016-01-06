package com.ob.view.table;

import java.awt.Component;
import java.text.DecimalFormat;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public abstract class TblBase extends JTable {

    protected DefaultTableModel dtm;

    public TblBase() {
        super();
        super.setFont(new java.awt.Font("", 0, 14));
        super.setGridColor(new java.awt.Color(222, 222, 222));
        super.setRowHeight(30);
        super.setSelectionBackground(new java.awt.Color(0, 107, 182));
        super.setSelectionForeground(new java.awt.Color(255, 255, 255));
        super.setShowVerticalLines(false);
        //setTableHeader(null);
    }

    public void setWidthColumn(int col, int width) {
        this.getColumnModel().getColumn(col).setMinWidth(width);
        this.getColumnModel().getColumn(col).setPreferredWidth(width);
        this.getColumnModel().getColumn(col).setMaxWidth(width);
        this.getColumnModel().getColumn(col).setWidth(width);
    }

    public DefaultTableModel getDtm() {
        return dtm;
    }

    static class DecimalFormatRenderer extends DefaultTableCellRenderer {

        private static final DecimalFormat formatoNumero = new DecimalFormat("#.00");

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

            value = formatoNumero.format((Number) value);

            return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        }
    }
}
