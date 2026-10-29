/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.utp.jsf.producto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import pe.edu.utp.jsf.producto.config.Conexion;
import pe.edu.utp.jsf.producto.modelo.Cliente;

/**
 *
 * @author Christiam Calero
 */
public class ClienteDAO {

    public List<Cliente> listar() {
        List<Cliente> lista = new ArrayList<>();
        try (Connection cn = Conexion.getConexion(); 
                PreparedStatement st = cn.prepareStatement(
                "SELECT * FROM cliente"); 
                ResultSet rs = st.executeQuery()) { //cierre de recursos
            
            while (rs.next()) {
                lista.add(new Cliente(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("correo"),
                        rs.getString("telefono")));
            }            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return lista;
    }
}
