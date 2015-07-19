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
    private SeccionDep  selectedSeccion;
    private UsuarioDao usuarioDao;
    private UsuarioDaoImplemet id;
   

    public PropuestaBean() {
        this.propuesta = new ArrayList<Propuesta>();
        selectedPropuesta = new Propuesta();
        this.id=new UsuarioDaoImplemet();
        selectedSeccion=new SeccionDep();
       

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

    public SeccionDep getSelectedSeccion() {
        return selectedSeccion;
    }
    
    public void setSelectedPropuesta(Propuesta selectedPropuesta) {
        this.selectedPropuesta = selectedPropuesta;
    }

    public void setSelectUsuario(Usuario selectUsuario) {
        this.selectUsuario = selectUsuario;
    }
    

    public void btnCrearPropuesta(ActionEvent actionEvent) {

      UsuarioDao usuarioDao = new UsuarioDaoImplemet();
        String msg;
        //  if (this.selectedPropuesta.getUsuario().getNumCreditos() >= 200) {
        if (this.selectedPropuesta.getNombreP().equals("") || this.selectedPropuesta.getDescripcionP().equals("")) {
            msg = "llene los campos obligatorios";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
    
            this.selectedPropuesta.setSeccionDep(new SeccionDep(1));
            this.selectedPropuesta.setComiteIdcomite(1);
            this.selectedPropuesta.setFechaP(new Date());
            this.selectedPropuesta.setUsuario(id.obtenerUsuario(1));
        //   System.out.println("usuario"+selectedPropuesta.getUsuario().getNombres());
            
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
           this.selectedPropuesta.setSeccionDep(new SeccionDep(1));
            this.selectedPropuesta.setComiteIdcomite(1);
            this.selectedPropuesta.setFechaP(new Date());
            this.selectedPropuesta.setUsuario(id.obtenerUsuario(1));
            
        if (usuarioDao.modificarPropuesta(this.selectedPropuesta)) {
            msg = "MOdificado correctamente su Propuesta";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            msg = "Error al Modifcar  Propuesta";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);

        }

    }

}
