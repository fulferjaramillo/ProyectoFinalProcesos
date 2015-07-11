/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import CapaDatos.Propuesta;
import CapaDatos.Proyectoft;
import CapaDatos.Usuario;
import Util.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author fernando
 */
public class UsuarioDaoImplemet implements UsuarioDao{

    @Override
    public Usuario findbyUsuario(Usuario usuario) {
        Usuario model=null;
        Session sesion=HibernateUtil.getSessionFactory().getCurrentSession();
        String sql="FROM Usuario WHERE correo='"+usuario.getCorreo()+"'";
        try {
            sesion.beginTransaction();
            model= (Usuario) sesion.createQuery(sql).uniqueResult();
           
        } catch (Exception e) {
            System.out.println(e);
        }
        return model;
    }

    @Override
    public Usuario login(Usuario usuario) {
       Usuario model=this.findbyUsuario(usuario);
      if(model !=null){
      if(!usuario.getPassword().equals(model.getPassword())){
          model=null;
      }
      }
       return model;
    }

    @Override
    public List<Propuesta> findAll() {
        List<Propuesta> listado=null;
        Session sesion=HibernateUtil.getSessionFactory().getCurrentSession();
        String sql="FROM Propuesta";
        try {
            sesion.beginTransaction();
            listado= sesion.createQuery(sql).list();
           
        } catch (Exception e) {
            System.out.println("No hay propuestas que mostrar"+e);
        }
        return listado;
    }
    
    @Override
    public List<Proyectoft> findAllProyectoft() {
        List<Proyectoft> listado=null;
        Session sesion=HibernateUtil.getSessionFactory().getCurrentSession();
        String sql="FROM Proyectoft";
        try {
            sesion.beginTransaction();
            listado= sesion.createQuery(sql).list();
           
        } catch (Exception e) {
            System.out.println("No hay proyectos que mostrar"+e);
        }
        return listado;
    }
    

    @Override
    public boolean crearPropuesta(Propuesta propuesta) {   
        boolean cr;
        Session sesion=HibernateUtil.getSessionFactory().getCurrentSession();
  
        try {
            sesion.beginTransaction();
            sesion.save(propuesta);
           sesion.getTransaction().commit();
           cr=true;
        } catch (Exception e) {
            cr=false;
            System.out.println(e.getMessage());
           // sesion.beginTransaction().rollback();
        }
        return cr;
        }
       
   
    @Override
    public boolean modificarPropuesta(Propuesta propuesta) {
        boolean cr=false;
        Session sesion=HibernateUtil.getSessionFactory().getCurrentSession();
  
        try {
            sesion.beginTransaction();
            sesion.update(propuesta);
            
           cr=true;
        } catch (Exception e) {
            cr=false;
            System.out.println(e);
        }
        return cr;
    } 

    @Override
    public boolean eliminarPropuesta(Integer id) {
      boolean cr=false;
        Session sesion=HibernateUtil.getSessionFactory().getCurrentSession();
  
        try {
            sesion.beginTransaction();
            Propuesta propuesta=(Propuesta) sesion.load(Propuesta.class, id);
            sesion.delete(propuesta);
           cr=true;
        } catch (Exception e) {
            cr=false;
            System.out.println(e);
        }
        return cr;
    } 

    
    
}
