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
    
    static class DecimalFormatRenderer extends DefaultTableCellRenderer {
      private static final DecimalFormat formatter = new DecimalFormat( "#.00" );
 
      @Override
      public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
 
         value = formatter.format((Number)value);
 
         return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
      }
   }
}
