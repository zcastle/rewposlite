package com.ob.controller;

import com.ob.util.Conn;
import java.sql.Connection;

/**
 *
 * @author jc
 */
abstract class Controller {
    
    protected Connection conn;
    
    public Controller(Connection conn){
        if(conn==null){
            conn = Conn.getConnection();
        }
        this.conn = conn;
    }
    
}
