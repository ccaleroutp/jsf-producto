/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.utp.jsf.producto.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pe.edu.utp.jsf.producto.config.Conexion;
import pe.edu.utp.jsf.producto.modelo.Producto;

/**
 *
 * @author Christiam Calero
 */
public class ProductoDAO {

    public List<Producto> listar() {
        List<Producto> lista = new ArrayList<>();
        try (Connection cn = Conexion.getConexion(); 
                Statement st = cn.createStatement(); 
                ResultSet rs = st.executeQuery( "SELECT * FROM producto")) {
            
            while (rs.next()) {
                lista.add(new Producto(rs.getInt("codigo"),
                        rs.getString("nombre"),
                        rs.getDouble("precio"),
                        rs.getInt("stock")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

}
