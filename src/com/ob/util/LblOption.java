package com.ob.util;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.Icon;
import javax.swing.JLabel;

/**
 *
 * @author jc
 */
public class LblOption extends JLabel {

    public LblOption() {
        super();
        init();
    }

    public LblOption(String text) {
        super(text);
        init();
    }

    public LblOption(Icon image) {
        super(image);
        init();
    }

    private void init() {
        setFont(new java.awt.Font("Arial", 1, 20));
        setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        setOpaque(true);
        setForeground(new java.awt.Color(255, 255, 255));
        setBackground(App.COLOR_HOLO_BLUE_LIGHT);
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
                } else if (getBackground() == App.COLOR_HOLO_ORANGE_LIGHT) {
                    setBackground(App.COLOR_HOLO_ORANGE_DARK);
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (getBackground() == App.COLOR_HOLO_BLUE_DARK) {
                    setBackground(App.COLOR_HOLO_BLUE_LIGHT);
                } else if (getBackground() == App.COLOR_HOLO_RED_DARK) {
                    setBackground(App.COLOR_HOLO_RED_LIGHT);
                } else if (getBackground() == App.COLOR_HOLO_ORANGE_DARK) {
                    setBackground(App.COLOR_HOLO_ORANGE_LIGHT);
                }
            }
        });
    }
}
