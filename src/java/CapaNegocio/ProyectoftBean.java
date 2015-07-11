/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocio;

import CapaDatos.Proyectoft;
import dao.UsuarioDao;
import dao.UsuarioDaoImplemet;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author fernando
 */
@Named(value = "proyectoftBean")
@Dependent
public class ProyectoftBean {
    
private List<Proyectoft>proyecto;
private Proyectoft selectedProyectoft;
   
    public ProyectoftBean() {
        this.proyecto=new ArrayList<Proyectoft>();
        this.selectedProyectoft=new Proyectoft();
    }

    public List<Proyectoft> getProyecto() {
        UsuarioDao usuarioDao=new UsuarioDaoImplemet();
        this.proyecto=usuarioDao.findAllProyectoft();
        return proyecto;
    }

    public Proyectoft getSelectedProyectoft() {
        return selectedProyectoft;
    }

    public void setSelectedProyectoft(Proyectoft selectedProyectoft) {
        this.selectedProyectoft = selectedProyectoft;
    }
    
    
}
