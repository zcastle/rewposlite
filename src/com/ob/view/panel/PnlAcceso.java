package com.ob.view.panel;

import com.ob.controller.UsuarioController;
import com.ob.model.Usuario;
import com.ob.util.App;
import com.ob.util.Conn;
import com.ob.util.Util;
import com.ob.view.FrmContainer;
import com.ob.view.comp.LblCajero;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.List;

public class PnlAcceso extends javax.swing.JPanel {

    public PnlAcceso() {
        initComponents();
        
        try {
            List<Usuario> cajeros = new UsuarioController(Conn.getConnection()).getAll(UsuarioController.ROL_CAJERO);
            LblCajero lblCajero;
            for (Usuario cajero : cajeros) {
                lblCajero = new LblCajero(cajero);
                lblCajero.addMouseListener(new MouseListener() {

                    @Override
                    public void mouseClicked(MouseEvent e) {
                        LblCajero label = (LblCajero) e.getSource();
                        Usuario usuario = label.getUsuario();
                        App.CAJERO = usuario;
                        PnlLogin.getLblCajeroFoto().setText(App.CAJERO.getNombre());
                        Util.changeCard(FrmContainer.getContainer(), "Login");
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {}

                    @Override
                    public void mouseReleased(MouseEvent e) {}

                    @Override
                    public void mouseEntered(MouseEvent e) {}

                    @Override
                    public void mouseExited(MouseEvent e) {}
                });
                add(lblCajero);
            }
        } catch (SQLException ex) {
            Util.e(ex.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
