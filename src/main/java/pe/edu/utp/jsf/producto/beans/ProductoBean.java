/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package pe.edu.utp.jsf.producto.beans;

import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import java.util.List;
import pe.edu.utp.jsf.producto.dao.ProductoDAO;
import pe.edu.utp.jsf.producto.modelo.Producto;

/**
 *
 * @author Christiam Calero
 */
@Named(value = "productoBean")
@RequestScoped
public class ProductoBean {

    /**
     * Creates a new instance of ProductoBean
     */
    public ProductoBean() {
    }

    private final ProductoDAO dao = new ProductoDAO();

    public List<Producto> getLista() {
        return dao.listar();
    }

}
