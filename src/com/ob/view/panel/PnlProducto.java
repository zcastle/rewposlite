package com.ob.view.panel;

import com.ob.controller.ProductoController;
import com.ob.model.Atencion;
import com.ob.model.Cliente;
import com.ob.model.Producto;
import com.ob.util.App;
import com.ob.util.Conn;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jc
 */
public class PnlProducto extends javax.swing.JPanel {

    private DefaultTableModel dtmP;

    public PnlProducto() {
        initComponents();
        dtmP = tblProductos.getDtm();
        primeraProductos();
    }

    private void primeraProductos() {
        try {
            List<Producto> productos = new ProductoController(Conn.getConnection()).getProductos();
            for (Producto p : productos) {
                tblProductos.addProducto(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PnlAtencion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void addProducto2Pedido() {
        Atencion a = new Atencion();
        Producto p = tblProductos.getSelected();
        a.setNroAtencion(App.CURRENT_ATENCION);
        a.setCajaId(App.CIA.getCentroCosto().getCaja().getId());
        a.setCajero(App.CAJERO);
        a.setCliente(new Cliente());
        a.setProducto(p);
        PnlAtencion.getTable().addProducto(a);
    }

    public static JTextField getTxtBuscar() {
        return txtBuscar;
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
        txtBuscar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtBuscarFocusGained(evt);
            }
        });
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        jPanel1.add(txtBuscar, gridBagConstraints);

        tblProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductosMouseClicked(evt);
            }
        });
        tblProductos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblProductosKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblProductosKeyReleased(evt);
            }
        });
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

    private void txtBuscarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarFocusGained
        getTxtBuscar().setText("");
    }//GEN-LAST:event_txtBuscarFocusGained

    private void tblProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductosMouseClicked
        if (evt.getClickCount() == 2) {
            addProducto2Pedido();
        }
    }//GEN-LAST:event_tblProductosMouseClicked

    private void tblProductosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblProductosKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            addProducto2Pedido();
        }
    }//GEN-LAST:event_tblProductosKeyReleased

    private void tblProductosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblProductosKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            evt.consume();
        }
    }//GEN-LAST:event_tblProductosKeyPressed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String nombre = getTxtBuscar().getText();
            if (nombre.length() >= 3) {
                try {
                    List<Producto> productos = new ProductoController(Conn.getConnection()).getProductos(nombre);
                    tblProductos.removeProductos();
                    for (Producto p : productos) {
                        tblProductos.addProducto(p);
                    }
                    if (dtmP.getRowCount() > 0) {
                        tblProductos.getSelectionModel().setSelectionInterval(0, 0);
                        tblProductos.grabFocus();
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(PnlAtencion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_txtBuscarKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.ob.view.table.TblProducto tblProductos;
    public static javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
