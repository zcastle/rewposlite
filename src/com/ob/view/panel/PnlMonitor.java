package com.ob.view.panel;

import com.ob.controller.AtencionController;
import com.ob.util.App;
import com.ob.util.Conn;
import com.ob.util.Record;
import com.ob.util.Util;
import com.ob.view.FrmContainer;
import com.ob.view.comp.BtnOption;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

public class PnlMonitor extends javax.swing.JPanel {

    public PnlMonitor() {
        initComponents();
        super.setVisible(false);
    }

    private void load() {
        try {
            BtnOption btn;
            removeAll();
            List<Record> monitor = new AtencionController(Conn.getConnection()).getMonitor();
            for (Record record : monitor) {
                if((boolean)record.getValor()){
                    btn = new BtnOption(record.getClave().toString(), BtnOption.LIBRE);
                }else{
                    btn = new BtnOption(record.getClave().toString(), BtnOption.OCUPADO);
                }
                btn.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        JLabel lblMesa = (JLabel) e.getSource();
                        int mesa = Integer.parseInt(lblMesa.getText());
                        PnlAtencion.getLblMesa().setText("P: "+mesa);
                        PnlAtencion.setAtencion(mesa);
                        App.CURRENT_ATENCION = mesa;
                        FrmContainer.getMonitor().setVisible(!FrmContainer.getMonitor().isVisible());
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
                add(btn);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PnlMonitor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
        if (visible) {
            load();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new java.awt.GridLayout(2, 10));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
