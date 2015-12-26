package com.ob.view.panel;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jc
 */
public class PnlProducto extends javax.swing.JPanel {

    private DefaultTableModel dtmP;
    private Object[] rowProducto = rowProducto = new Object[5];

    public PnlProducto() {
        initComponents();
        //
        dtmInit();
        //
        dtmP = tblProductos.getDtm();
        /*try {
            for (Producto p : App.PRODUCTOS.getProductos()) {
                rowProducto[0] = p.getId();
                rowProducto[1] = p.getNombre();
                rowProducto[2] = p.getPrecio();
                rowProducto[3] = p.getStock();
                rowProducto[4] = p.getUnidad();
                dtmP.addRow(rowProducto);
            }
        } catch (IOException ex) {
            Logger.getLogger(PnlProducto.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }

    private void dtmInit() {
        //DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        //rightRenderer.setHorizontalAlignment(JLabel.CENTER);
    }

    private void addProducto(int id) {
        /*try {
            System.out.println(App.PRODUCTOS.getProductoById(id).getNombre());
        } catch (IOException ex) {
            Logger.getLogger(PnlProducto.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        txtBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductos = new com.ob.view.table.TblProducto();

        setBorder(null);
        setLayout(new java.awt.CardLayout());

        jPanel1.setLayout(new java.awt.GridBagLayout());

        txtBuscar.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        txtBuscar.setForeground(new java.awt.Color(182, 167, 167));
        txtBuscar.setText("Buscar (ctrl+B)");
        txtBuscar.setToolTipText("Buscar Producto");
        txtBuscar.setFocusAccelerator('b');
        txtBuscar.setMargin(new java.awt.Insets(5, 5, 5, 5));
        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        txtBuscar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtBuscarFocusGained(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        jPanel1.add(txtBuscar, gridBagConstraints);

        jScrollPane1.setViewportView(tblProductos);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel1.add(jScrollPane1, gridBagConstraints);

        add(jPanel1, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        String nombre = txtBuscar.getText();
        if (nombre.length() >= 3) {
            dtmInit();
            /*try {
                for (Producto p : App.PRODUCTOS.getProductoContainName(nombre)) {
                    rowProducto[0] = p.getId();
                    rowProducto[1] = p.getNombre();
                    rowProducto[2] = p.getPrecio();
                    rowProducto[3] = p.getStock();
                    rowProducto[4] = p.getUnidad();
                    dtmP.addRow(rowProducto);
                }
                if (dtmP.getRowCount()>0) {
                    tblProductos.getSelectionModel().setSelectionInterval(0, 0);
                    tblProductos.grabFocus();
                }
            } catch (IOException ex) {
                Logger.getLogger(PnlProducto.class.getName()).log(Level.SEVERE, null, ex);
            }*/
        }
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void txtBuscarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarFocusGained
        txtBuscar.setText("");
    }//GEN-LAST:event_txtBuscarFocusGained

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.ob.view.table.TblProducto tblProductos;
    public static javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
