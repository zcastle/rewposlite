package com.ob.view.comp;

import com.ob.util.Util;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class TxtNumeros extends JTextField implements KeyListener {
    
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
        addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        String value = String.valueOf(e.getKeyChar());
        //System.out.println(e.getKeyChar());
        if(!Util.isNumeric(value)){
            //System.out.println("index: "+getText().indexOf("."));
            if(getText().indexOf(".")>0){ //this.isMoneda && 
                e.consume();
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
}
