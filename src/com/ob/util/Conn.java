package com.ob.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jc
 */
public class Conn {

    private static Connection conexion;

    static {
        String fileName = "config.properties";
        InputStream input = null;
        Properties prop = new Properties();
        try {
            input = new FileInputStream(fileName);
            //input = Conn.class.getClassLoader().getResourceAsStream(fileName);
            prop.load(input);

            Class.forName("com.mysql.jdbc.Driver");
            
            String host = prop.getProperty("HOST");
            String user = prop.getProperty("USER");
            String pass = prop.getProperty("PASS");
            String db = prop.getProperty("DB");
            String url = "jdbc:mysql://".concat(host).concat("/").concat(db);
            //Util.e(url);
            conexion = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException e) {
            conexion = null;
        } catch (FileNotFoundException e) {
            conexion = null;
        } catch (IOException e) {
            conexion = null;
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    Util.e(e.getMessage());
                }
            }
        }
    }

    public static Connection getConnection() {
        return conexion;
    }

}
