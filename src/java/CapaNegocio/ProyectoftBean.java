/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocio;

import CapaDatos.Comite;
import CapaDatos.Propuesta;
import CapaDatos.Proyectoft;
import CapaDatos.SeccionDep;
import dao.UsuarioDao;
import dao.UsuarioDaoImplemet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author fernando
 */
@Named(value = "proyectoftBean")
@Dependent
public class ProyectoftBean {

    private List<Proyectoft> proyecto;
    private List<Comite> fillcomite;
    private Proyectoft selectedProyectoft;
    private Propuesta propuesta;
    private UsuarioDaoImplemet id;
    private Comite comite;

    public ProyectoftBean() {
        this.proyecto = new ArrayList<Proyectoft>();
        this.selectedProyectoft = new Proyectoft();
         this.propuesta = new Propuesta();
        this.comite=new Comite();
        this.id = new UsuarioDaoImplemet();

    }

    

    public List<Proyectoft> getProyecto() {
        UsuarioDao usuarioDao = new UsuarioDaoImplemet();
        this.proyecto = usuarioDao.findAllProyectoft();
       
        return proyecto;
    }

    public List<Comite> getFillcomite() {
        UsuarioDao usuarioDao = new UsuarioDaoImplemet();
        this.fillcomite = usuarioDao.findAllComite();
        return fillcomite;
    }

    public Propuesta getPropuesta() {
        return propuesta;
    }
    

    public Proyectoft getSelectedProyectoft() {
        return selectedProyectoft;
    }

    public Comite getComite() {
        return comite;
        
    }

    public void setSelectedProyectoft(Proyectoft selectedProyectoft) {
        this.selectedProyectoft = selectedProyectoft;
    }

    public void btnCrearProyectoft(ActionEvent actionEvent) {
        System.out.println("estoy aqui");

        UsuarioDao usuarioDao = new UsuarioDaoImplemet();
        String msg;
        this.propuesta.setNombreP(this.selectedProyectoft.getNombrePy());
       
        this.selectedProyectoft.setFechaIniPy(new Date());
        this.selectedProyectoft.setPorcentajePy(this.selectedProyectoft.getPorcentajePy());
        this.selectedProyectoft.setSeccionDep(new SeccionDep(1));
        this.selectedProyectoft.setUsuario(id.obtenerUsuario(1));

        if (usuarioDao.crearProyectoft(this.selectedProyectoft)) {
            msg = "Confirmado su proyectot";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            msg = "Error al confirmar ";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
            System.out.println("sddsfsdf" + msg);
        }
    }
}
