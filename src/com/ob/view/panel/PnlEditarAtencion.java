package com.ob.view.panel;

import com.ob.model.Atencion;
import com.ob.util.Util;
import com.ob.view.comp.BtnOption;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PnlEditarAtencion extends javax.swing.JPanel {

    private Atencion atencion = null;
    private JPanel pnlBuscar = null;
    
    public PnlEditarAtencion(JPanel pnlBuscar) {
        initComponents();
        this.pnlBuscar = pnlBuscar;
    }
    
    public void setAtencion(Atencion atencion){
        if(this.atencion == null){
            cargarCampos(atencion);
        }else if(this.atencion.getId()!=atencion.getId()){
            cargarCampos(atencion);
        }
        this.atencion = atencion;
    }
    
    private void cargarCampos(Atencion atencion){
        txtNombre.setText(atencion.getProducto().getNombre());
        txtCantidad.setText(atencion.getProducto().getCantidad()+"");
        txtPrecio.setText(atencion.getProducto().getPrecio()+"");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtCantidad = new com.ob.view.comp.TxtNumeros();
        jLabel3 = new javax.swing.JLabel();
        txtPrecio = new com.ob.view.comp.TxtNumeros(true);
        jPanel1 = new javax.swing.JPanel();
        btnEditar = new com.ob.view.comp.BtnOption(BtnOption.EDITAR);
        btnEliminar = new com.ob.view.comp.BtnOption(BtnOption.ELIMINAR);
        jPanel2 = new javax.swing.JPanel();

        setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        jLabel1.setText("Producto:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 5);
        add(jLabel1, gridBagConstraints);

        txtNombre.setFont(new java.awt.Font("Ubuntu", 0, 20)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        add(txtNombre, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        jLabel2.setText("Cantidad:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 5);
        add(jLabel2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        add(txtCantidad, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        jLabel3.setText("Precio:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 5);
        add(jLabel3, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        add(txtPrecio, gridBagConstraints);

        jPanel1.setLayout(new java.awt.GridLayout(1, 2));

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ob/images/edit_file-48.png"))); // NOI18N
        btnEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditarMouseClicked(evt);
            }
        });
        jPanel1.add(btnEditar);

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ob/images/delete_file-48.png"))); // NOI18N
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarMouseClicked(evt);
            }
        });
        jPanel1.add(btnEliminar);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        add(jPanel1, gridBagConstraints);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 132, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(jPanel2, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarMouseClicked
        int res = JOptionPane.showConfirmDialog(null, "Desea editar el producto?", "Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(res==JOptionPane.YES_OPTION){
            PnlAtencion.getTable().editProducto(this.atencion, txtNombre.getText(), Double.parseDouble(txtCantidad.getText()), Double.parseDouble(txtPrecio.getText()));
        }
    }//GEN-LAST:event_btnEditarMouseClicked

    private void btnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseClicked
        int res = JOptionPane.showConfirmDialog(null, "Desea eliminar el producto?", "Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(res==JOptionPane.YES_OPTION){
            PnlAtencion.getTable().eliminarProducto(this.atencion);
            Util.changeCard(this.pnlBuscar, "Producto");
        }
    }//GEN-LAST:event_btnEliminarMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.ob.view.comp.BtnOption btnEditar;
    private com.ob.view.comp.BtnOption btnEliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private com.ob.view.comp.TxtNumeros txtCantidad;
    private javax.swing.JTextField txtNombre;
    private com.ob.view.comp.TxtNumeros txtPrecio;
    // End of variables declaration//GEN-END:variables
}
