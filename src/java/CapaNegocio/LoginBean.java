/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocio;

import CapaDatos.Usuario;
import Util.MyUtil;
import dao.UsuarioDao;
import dao.UsuarioDaoImplemet;
import java.awt.event.ActionEvent;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;

/**
 *
 * @author fernando
 */
//@Named(value = "loginBean")
@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

    /**
     * Creates a new instance of LoginBean
     */
    private Usuario usuario;
    private UsuarioDao usuarioDao;

    public LoginBean() {
        this.usuarioDao = new UsuarioDaoImplemet();
        if (this.usuario == null) {
            this.usuario = new Usuario();
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void login(ActionEvent event) {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message;
        boolean loggedIn;
        String ruta = "";

        this.usuario = this.usuarioDao.login(this.usuario);
        if (this.usuario != null && this.usuario.getRol()==1) {
            loggedIn = true;
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("Usuario", this.usuario.getCorreo());
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido", this.usuario.getCorreo());
            ruta = MyUtil.basepathLOgin() + "views/Estudiante.xhtml?1";

        }else if (this.usuario != null && this.usuario.getRol()==2) {
            loggedIn = true;
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("Usuario", this.usuario.getCorreo());
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido", this.usuario.getCorreo());
            ruta = MyUtil.basepathLOgin() + "views/Docente.xhtml";
        }else if (this.usuario != null && this.usuario.getRol()==3) {
            loggedIn = true;
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("Usuario", this.usuario.getCorreo());
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido", this.usuario.getCorreo());
            ruta = MyUtil.basepathLOgin() + "views/Director.xhtml";
        }else{
        
            loggedIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Usuario y/o clave invalidos");
            if (this.usuario == null) {
                this.usuario = new Usuario();
            }
        }

        FacesContext.getCurrentInstance().addMessage(null, message);
        context.addCallbackParam("loggedIn", loggedIn);
        context.addCallbackParam("ruta", ruta);
    }
    public void logout(){
    String ruta=MyUtil.basepathLOgin()+"login.xhtml";
    RequestContext context=RequestContext.getCurrentInstance();
    FacesContext facesContext=FacesContext.getCurrentInstance();
    
        HttpSession session=(HttpSession) facesContext.getExternalContext().getSession(false);
        session.invalidate();
        
        context.addCallbackParam("loggetOut", true);
        context.addCallbackParam("ruta", ruta);
        
        
    }
}
