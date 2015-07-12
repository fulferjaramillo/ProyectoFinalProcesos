/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import CapaDatos.Propuesta;
import CapaDatos.Proyectoft;
import CapaDatos.Usuario;
import java.util.List;

/**
 *
 * @author fernando
 */
public interface UsuarioDao {
    public Usuario findbyUsuario(Usuario usuario);
    public Usuario obtenerUsuario(Integer idUsuario);
    public Usuario login(Usuario usuario);
    public List<Propuesta> findAll();
     public List<Proyectoft> findAllProyectoft();
    public boolean crearPropuesta(Propuesta propuesta);
    public boolean modificarPropuesta(Propuesta propuesta);
}
