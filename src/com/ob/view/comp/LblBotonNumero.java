/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ob.view.comp;

import com.ob.util.App;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author jc
 */
public class LblBotonNumero  extends JLabel implements MouseListener {
    
    private JTextField txtNumero;

    public LblBotonNumero(String name, JTextField txtNumero) {
        super(name);
        this.txtNumero = txtNumero;
        setOpaque(true);
        setBackground(new java.awt.Color(0xffcccccc));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        setFont(new java.awt.Font("Tahoma", 0, 24));
        setForeground(new java.awt.Color(0, 0, 0));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Implement this method
        JLabel label = (JLabel) e.getSource();
        if(label.getToolTipText().equals("Limpiar")) {
            this.txtNumero.setText("");
        } else {
            this.txtNumero.setText(this.txtNumero.getText().concat(label.getText()));
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Implement this method
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Implement this method
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        setForeground(App.COLOR_HOLO_RED_DARK);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        setForeground(new java.awt.Color(0, 0, 0));
    }
}
