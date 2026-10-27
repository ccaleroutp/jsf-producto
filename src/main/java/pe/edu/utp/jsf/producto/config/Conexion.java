/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.utp.jsf.producto.config;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Christiam Calero
 */
public class Conexion {

    public static Connection getConexion()
            throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");

        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/empresa",
                "root", "12345678");
    }

}
