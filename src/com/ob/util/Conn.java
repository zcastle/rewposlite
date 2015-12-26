package com.ob.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jc
 */
public class Conn {

    private static Connection conexion;
    
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String host = "jdbc:mysql://localhost/dbrewsoft2014";
            String user = "sistema";
            String pass = "123456";
            conexion = DriverManager.getConnection(host, user, pass);
        } catch (ClassNotFoundException | SQLException ex) {
            conexion = null;
        }
    }

    public static Connection getConnection() {
        return conexion;
    }

}
