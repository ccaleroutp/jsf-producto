/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package pe.edu.utp.jsf.producto.beans;

import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import java.io.Serializable;
import pe.edu.utp.jsf.producto.dao.UsuarioDAO;

/**
 *
 * @author Christiam Calero
 */
@Named(value = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {

    private String usuario;
    private String clave;

    @Inject
    private UsuarioDAO usuarioDAO;

    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() {
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String validarAcceso() {
        if (usuarioDAO.validarAcceso(usuario, clave)) {
            clave = null;
            
            return "index";
        }
        return null;
    }

}
