/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Martinez
 */
public class ConexionDB {
    
    private static String url = "jdbc:postgresql://localhost:5432/empresa";
    private static String password = "984984";
    private static String user = "postgres";

    private static Connection bdConn = null;
    private static ConexionDB myConn;

    ConexionDB() {
        try {
            Class.forName("org.postgresql.Driver");
            bdConn = DriverManager.getConnection(url, user, password);

        } catch (ClassNotFoundException | SQLException e) {
        }
    }

    public static ConexionDB getInstance() {
        if (myConn == null) {
            myConn = new ConexionDB();
        }
        return myConn;
    }
    
}
