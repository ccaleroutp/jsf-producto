/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.utp.jsf.producto.config;

import jakarta.faces.component.UIViewRoot;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.PhaseEvent;
import jakarta.faces.event.PhaseId;
import jakarta.faces.event.PhaseListener;
import java.util.Locale;

/**
 *
 * @author Christiam Calero
 */
public class IdiomaPhaseListener implements PhaseListener {

    @Override
    public void afterPhase(PhaseEvent event) {

    }

    @Override
    public void beforePhase(PhaseEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();

        UIViewRoot viewRoot = context.getViewRoot();

        if (viewRoot == null) {
            return;            
        }
        
        Object idiomaSesion
                = context.getExternalContext().getSessionMap().get("selectLanguage");

        context.getViewRoot().setLocale(
                Locale.forLanguageTag(idiomaSesion
                != null ? idiomaSesion.toString() : "es"));
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }

}
