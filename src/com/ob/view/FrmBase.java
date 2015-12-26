package com.ob.view;

import com.ob.util.App;

import javax.swing.JFrame;

public abstract class FrmBase extends JFrame {
    
    public FrmBase() {
        super();
        //setUndecorated(true);
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/com/ob/images/pin.png")).getImage());
    }
    
    @Override
    public void setVisible(boolean b) {
        setSize(App.FRMMAIN_DIMENSION);
        setLocationRelativeTo(null);
        super.setVisible(b);
    }
    
}
