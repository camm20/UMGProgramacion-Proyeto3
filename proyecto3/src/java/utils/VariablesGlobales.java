/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author cesar
 */
public class VariablesGlobales {
    public static final String DRIVER_DB = "org.postgresql.Driver";
    public static final String URL_DB ="jdbc:postgresql://localhost/programacion2";
    public static final String USER_DB = "programacion";
    public static final String PASSWORD_DB = "programacion";
    public static Connection conn;
    static{
        try {
            Class.forName(DRIVER_DB);
            conn = DriverManager.getConnection(URL_DB, USER_DB, PASSWORD_DB);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
