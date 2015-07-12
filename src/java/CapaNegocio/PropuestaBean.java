/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocio;

import CapaDatos.Propuesta;
import CapaDatos.SeccionDep;
import CapaDatos.Usuario;
import dao.UsuarioDao;
import dao.UsuarioDaoImplemet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author fernando
 */
@Named(value = "PropuestaBean")
@RequestScoped
public class PropuestaBean {

    private List<Propuesta> propuesta;
    private Propuesta selectedPropuesta;
    private Usuario selectUsuario;

    public PropuestaBean() {
        this.propuesta = new ArrayList<Propuesta>();
        selectedPropuesta = new Propuesta();

    }

    public List<Propuesta> getPropuestas() {
        UsuarioDao usuarioDao = new UsuarioDaoImplemet();
        this.propuesta = usuarioDao.findAll();
        return propuesta;
    }

    public Propuesta getSelectedPropuesta() {
        return selectedPropuesta;

    }

    public Usuario getSelectUsuario() {

        return selectUsuario;
    }

    public void setSelectedPropuesta(Propuesta selectedPropuesta) {
        this.selectedPropuesta = selectedPropuesta;
    }

    public void btnCrearPropuesta(ActionEvent actionEvent) {

        UsuarioDao usuarioDao = new UsuarioDaoImplemet();
        //selectUsuario = usuarioDao.obtenerUsuario(1);

        String msg;
        //this.selectedPropuesta.setNombreP(this.selectedPropuesta.getNombreP());
        //this.selectedPropuesta.setDescripcionP(this.selectedPropuesta.getDescripcionP());

//        
//          this.selectedPropuesta.setComiteIdcomite(2);
//            this.selectedPropuesta.setIdpropuesta(4);
//              this.selectedPropuesta.setSeccionDep(new SeccionDep(1));
        //this.selectedPropuesta.setComentarioP(this.selectedPropuesta.getComentarioP());
        //  if (this.selectedPropuesta.getUsuario().getNumCreditos() >= 200) {
        if (this.selectedPropuesta.getNombreP().equals("") || this.selectedPropuesta.getDescripcionP().equals("")
                || this.selectedPropuesta.getComentarioP().equals("")) {
            msg = "llene los campos obligatorios";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            selectedPropuesta.setComiteIdcomite(1);
            selectedPropuesta.setFechaP(new Date());
            if (usuarioDao.crearPropuesta(this.selectedPropuesta)) {
                msg = "Guardado correctamente su Propuesta";
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
                FacesContext.getCurrentInstance().addMessage(null, message);
            } else {
                msg = "Error al crear  Propuesta";
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null);
                FacesContext.getCurrentInstance().addMessage(null, message);
                System.out.println("sddsfsdf" + msg);
            }
        }
//        } else {
//            msg = "el numero de creditos es menos a 200";
//            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null);
//            FacesContext.getCurrentInstance().addMessage(null, message);
//        }

    }

    public void btnEditarPropuesta(ActionEvent actionEvent) {
        UsuarioDao usuarioDao = new UsuarioDaoImplemet();
        String msg;
//        this.selectedPropuesta.setNombreP(this.selectedPropuesta.getNombreP());
//        this.selectedPropuesta.setDescripcionP(this.selectedPropuesta.getDescripcionP());
//        this.selectedPropuesta.setEstadoP(this.selectedPropuesta.getEstadoP());
//        this.selectedPropuesta.setComentarioP(this.selectedPropuesta.getComentarioP());
        
        System.out.println("nombe"+selectedPropuesta.getNombreP());
         System.out.println("descrifpsdfds"+selectedPropuesta.getDescripcionP());
          System.out.println("estao"+selectedPropuesta.getEstadoP());
           System.out.println("cimentario"+selectedPropuesta.getComentarioP());
        if (usuarioDao.modificarPropuesta(this.selectedPropuesta)) {
            msg = "MOdificado correctamente su Propuesta";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            msg = "Erroro al Modifcar  Propuesta";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);

        }

    }

}
