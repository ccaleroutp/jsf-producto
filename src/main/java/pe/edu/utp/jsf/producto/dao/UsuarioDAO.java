/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.utp.jsf.producto.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import pe.edu.utp.jsf.producto.config.Conexion;

/**
 *
 * @author Christiam Calero
 */
public class UsuarioDAO implements Serializable{

    public boolean validarAcceso(String usuario, String clave) {
        boolean acceso = false;
        try (Connection cn = Conexion.getConexion(); PreparedStatement ps
                = cn.prepareStatement(
                        "SELECT * FROM usuario WHERE usuario =  ? AND  clave =  ?")) {
            ps.setString(1, usuario);
            ps.setString(2, clave);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (Exception e) {
            System.err.printf("Error: %s", e.getMessage());
        }
        return acceso;
    }

}
