/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.utp.jsf.producto.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
public class ProductoDAO implements Serializable{

    public List<Producto> listar() {
        List<Producto> lista = new ArrayList<>();
        try (Connection cn = Conexion.getConexion(); 
                Statement st = cn.createStatement(); 
                ResultSet rs = st.executeQuery("SELECT * FROM producto")) {

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

    public void agregar(Producto producto) {
        String sql = "INSERT INTO producto (nombre, precio, stock) values ( ?, ?, ?)";
        try (Connection cn = Conexion.getConexion(); PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, producto.getNombre());
            ps.setDouble(2, producto.getPrecio());
            ps.setInt(3, producto.getStock());

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void actualizar(Producto producto) {
        String sql = """ 
                     UPDATE producto SET nombre = ?, precio = ?, stock =? WHERE codigo = ? 
                    """;
        try (Connection cn = Conexion.getConexion(); PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, producto.getNombre());
            ps.setDouble(2, producto.getPrecio());
            ps.setInt(3, producto.getStock());

            ps.setInt(4, producto.getCodigo());

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void eliminar(int idproducto) {
        String sql = "DELETE FROM producto WHERE codigo = ?";
        try (Connection cn = Conexion.getConexion(); PreparedStatement ps = cn.prepareStatement(sql)) {
            
            ps.setInt(1, idproducto);
            
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
