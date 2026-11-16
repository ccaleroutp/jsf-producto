/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package pe.edu.utp.jsf.producto.beans;

import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.FacesContext;
import java.io.Serializable;
import java.util.Locale;

/**
 *
 * @author Christiam Calero
 */
@Named(value = "idiomaBean")
@SessionScoped
public class IdiomaBean implements Serializable {

    private String idioma = "es";

    /**
     * Creates a new instance of IdiomaBean
     */
    public IdiomaBean() {
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public void cambiarIdioma(String idioma) {
        this.idioma = idioma;

        FacesContext context = FacesContext.getCurrentInstance();

        context.getExternalContext().getSessionMap().put("selectLanguage",
                idioma);

        context.getViewRoot().setLocale(Locale.forLanguageTag(idioma));

    }
}
