package com.ob.view.comp;

import com.ob.util.App;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;

/**
 *
 * @author jc
 */
public class BtnOption extends JLabel {
    
    public static final int ACEPTAR = 0;
    public static final int CANCELAR = 1;
    public static final int EDITAR = 3;
    public static final int ELIMINAR = 4;
    private int TYPE = 0;
    
    public BtnOption() {
        super();
        init();
    }

    public BtnOption(String text) {
        super(text);
        init();
    }

    /*public BtnOption(Icon image) {
        super(image);
        init();
    }*/
    
    public BtnOption(int type) {
        super();
        this.TYPE = type;
        init();
    }

    private void init() {
        setFont(new java.awt.Font("Arial", 1, 20));
        setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        setOpaque(true);
        setForeground(new java.awt.Color(255, 255, 255));
        switch (this.TYPE) {
            case BtnOption.ACEPTAR:
                setBackground(App.COLOR_HOLO_BLUE_LIGHT);
                break;
            case BtnOption.CANCELAR:
            case BtnOption.ELIMINAR:
                setBackground(App.COLOR_HOLO_RED_LIGHT);
                break;
            case BtnOption.EDITAR:
                setBackground(App.COLOR_HOLO_GREEN_LIGHT);
                break;
            default:
                setBackground(App.COLOR_HOLO_BLUE_LIGHT);
                break;
        }
        
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {
                if (getBackground() == App.COLOR_HOLO_BLUE_LIGHT) {
                    setBackground(App.COLOR_HOLO_BLUE_DARK);
                } else if (getBackground() == App.COLOR_HOLO_RED_LIGHT) {
                    setBackground(App.COLOR_HOLO_RED_DARK);
                } else if (getBackground() == App.COLOR_HOLO_GREEN_LIGHT) {
                    setBackground(App.COLOR_HOLO_GREEN_DARK);
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (getBackground() == App.COLOR_HOLO_BLUE_DARK) {
                    setBackground(App.COLOR_HOLO_BLUE_LIGHT);
                } else if (getBackground() == App.COLOR_HOLO_RED_DARK) {
                    setBackground(App.COLOR_HOLO_RED_LIGHT);
                } else if (getBackground() == App.COLOR_HOLO_GREEN_DARK) {
                    setBackground(App.COLOR_HOLO_GREEN_LIGHT);
                }
            }
        });
    }
}
