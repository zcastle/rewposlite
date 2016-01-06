package com.ob.view.comp;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class TxtNumeros extends JTextField {
    
    private boolean isMoneda;
    
    public TxtNumeros(){
        super();
        init();
    }
    
    public TxtNumeros(boolean isMoneda){
        super();
        this.isMoneda = isMoneda;
        init();
    }
    
    private void init() {
        setHorizontalAlignment(SwingConstants.RIGHT);
        setFont(new java.awt.Font("Ubuntu", 0, 20));
    }
    
}
