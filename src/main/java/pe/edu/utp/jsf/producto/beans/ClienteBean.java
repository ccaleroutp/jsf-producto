/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package pe.edu.utp.jsf.producto.beans;

import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import java.util.List;
import pe.edu.utp.jsf.producto.dao.ClienteDAO;
import pe.edu.utp.jsf.producto.modelo.Cliente;

/**
 *
 * @author Christiam Calero
 */
@Named(value = "clienteBean")
@RequestScoped
public class ClienteBean {

    /**
     * Creates a new instance of ClienteBean
     */
    public ClienteBean() {
    }

    @Inject
    private ClienteDAO dao;

    public List<Cliente> getLista() {
        return dao.listar();
    }
}
