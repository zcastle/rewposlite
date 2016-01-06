package com.ob.view.panel;

import com.ob.controller.UsuarioController;
import com.ob.util.App;
import com.ob.util.Conn;
import com.ob.util.Util;
import com.ob.view.FrmContainer;
import com.ob.view.comp.LblCajero;
import java.sql.SQLException;

public class PnlLogin extends javax.swing.JPanel {

    public PnlLogin() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        lblCajeroFoto = new com.ob.view.comp.LblCajero();
        txtClave = new javax.swing.JPasswordField();
        pnlTecladoNumerico1 = new com.ob.view.comp.PnlTecladoNumerico(txtClave);
        btnIngresar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        add(lblCajeroFoto, gridBagConstraints);

        txtClave.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        add(txtClave, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        add(pnlTecladoNumerico1, gridBagConstraints);

        btnIngresar.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        btnIngresar.setText("Aceptar");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 1.0;
        add(btnIngresar, gridBagConstraints);

        btnRegresar.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 1.0;
        add(btnRegresar, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        jLabel1.setText("Clave:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        add(jLabel1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    public static LblCajero getLblCajeroFoto() {
        return lblCajeroFoto;
    }
    
    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        App.CAJERO = null;
        txtClave.setText("");
        Util.changeCard(FrmContainer.getContainer(), "Acceso");
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        //
        String clave = new String(txtClave.getPassword());
        if(clave.isEmpty()){
            Util.msg("Ingrese su clave");
            return;
        }
        try {
            boolean isLogin = new UsuarioController(Conn.getConnection()).isLogin(App.CAJERO, clave);
            if(isLogin){
                FrmContainer.getLblCajero().setText(App.CAJERO.getNombre());
                Util.changeCard(FrmContainer.getContainer(), "Pedido");
                PnlAtencion.setAtencion(App.DEFAULT_ATENCION);
            }else{
                Util.msg("Clave incorrecta");
                txtClave.setText("");
            }
        } catch(SQLException e){
            Util.e(e.getMessage());
        }
    }//GEN-LAST:event_btnIngresarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private static com.ob.view.comp.LblCajero lblCajeroFoto;
    private com.ob.view.comp.PnlTecladoNumerico pnlTecladoNumerico1;
    private javax.swing.JPasswordField txtClave;
    // End of variables declaration//GEN-END:variables
}
