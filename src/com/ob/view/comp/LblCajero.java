package com.ob.view.comp;

import com.ob.model.Usuario;
import javax.swing.JLabel;

public class LblCajero extends JLabel {
    
    private Usuario usuario;
    
    public LblCajero() {
        super("CAJERO");
        init(new Usuario());
    }
    
    public LblCajero(Usuario usuario) {
        super(usuario.getNombre());
        init(usuario);
    }
    
    private void init(Usuario usuario){
        this.usuario = usuario;
        this.setFont(new java.awt.Font("", 1, 15));
        if(usuario.getSexo().equalsIgnoreCase("M")){
            this.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ob/images/usuario_m.png")));
        }else{
            this.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ob/images/usuario_f.png")));
        }
        this.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        this.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        this.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        this.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    }

    public Usuario getUsuario() {
        return usuario;
    }
    
}
