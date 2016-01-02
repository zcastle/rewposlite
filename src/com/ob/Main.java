package com.ob;

import com.ob.controller.CiaController;
import com.ob.model.Cia;
import com.ob.util.App;
import com.ob.util.Conn;
import com.ob.util.Util;
import com.ob.view.FrmContainer;
import java.sql.Connection;
import java.sql.SQLException;


public class Main {

    public static void main(String[] args) {
        if (!Util.isFileshipAlreadyRunning()) {
            Util.showMessageAndExit(App.MESSAGE_ERROR_INSTANCIA_CARGADA);
        }
        
        for (String arg : args) {
            if (arg.equals("--root")) {
                App.ISROOT = true;
                Util.i("is Root...");
            }
        }
        
        final Connection conn = Conn.getConnection();
        if(conn==null){
            Util.showMessageAndExit(App.MESSAGE_ERROR_DB);
        }else{
            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    try {
                        Cia cia = new CiaController(conn).getCia();
                        App.IGV = cia.getCentroCosto().getCaja().getIgv();
                        App.SERVICIO = cia.getCentroCosto().getServicio();
                        App.CIA = cia;
                        new FrmContainer(cia).setVisible(true);
                    } catch (SQLException ex) {
                        Util.e(ex.getMessage());
                    }
                }
            });
        }
    }

}
