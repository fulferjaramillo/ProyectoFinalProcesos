package CapaDatos;
// Generated 10/07/2015 23:07:03 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Usuario generated by hbm2java
 */
@Entity
@Table(name="usuario"
    ,catalog="procesosproyectofinaldb"
)
public class Usuario  implements java.io.Serializable {


     private Integer idusuario;
     private SeccionDep seccionDep;
     private Integer cedula;
     private String nombres;
     private String apellidos;
     private String correo;
     private Integer numCreditos;
     private String password;
     private int rol;
     private int idproyectoft;
     private int idDireccion;
     private int idcomite;
     private Set propuestas = new HashSet(0);
     private Set proyectofts = new HashSet(0);

    public Usuario() {
        
    }

	
    public Usuario(int rol, int idproyectoft, int idDireccion, int idcomite) {
        this.rol = rol;
        this.idproyectoft = idproyectoft;
        this.idDireccion = idDireccion;
        this.idcomite = idcomite;
    }
    public Usuario(SeccionDep seccionDep, Integer cedula, String nombres, String apellidos, String correo, Integer numCreditos, String password, int rol, int idproyectoft, int idDireccion, int idcomite, Set propuestas, Set proyectofts) {
       this.seccionDep = seccionDep;
       this.cedula = cedula;
       this.nombres = nombres;
       this.apellidos = apellidos;
       this.correo = correo;
       this.numCreditos = numCreditos;
       this.password = password;
       this.rol = rol;
       this.idproyectoft = idproyectoft;
       this.idDireccion = idDireccion;
       this.idcomite = idcomite;
       this.propuestas = propuestas;
       this.proyectofts = proyectofts;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idusuario", unique=true, nullable=false)
    public Integer getIdusuario() {
        return this.idusuario;
    }
    
    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idsec")
    public SeccionDep getSeccionDep() {
        return this.seccionDep;
    }
    
    public void setSeccionDep(SeccionDep seccionDep) {
        this.seccionDep = seccionDep;
    }

    
    @Column(name="cedula")
    public Integer getCedula() {
        return this.cedula;
    }
    
    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }

    
    @Column(name="nombres", length=45)
    public String getNombres() {
        return this.nombres;
    }
    
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    
    @Column(name="apellidos", length=45)
    public String getApellidos() {
        return this.apellidos;
    }
    
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    
    @Column(name="correo", length=45)
    public String getCorreo() {
        return this.correo;
    }
    
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    
    @Column(name="num_creditos")
    public Integer getNumCreditos() {
        return this.numCreditos;
    }
    
    public void setNumCreditos(Integer numCreditos) {
        this.numCreditos = numCreditos;
    }

    
    @Column(name="password", length=45)
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    
    @Column(name="rol", nullable=false)
    public int getRol() {
        return this.rol;
    }
    
    public void setRol(int rol) {
        this.rol = rol;
    }

    
    @Column(name="idproyectoft", nullable=false)
    public int getIdproyectoft() {
        return this.idproyectoft;
    }
    
    public void setIdproyectoft(int idproyectoft) {
        this.idproyectoft = idproyectoft;
    }

    
    @Column(name="id_direccion", nullable=false)
    public int getIdDireccion() {
        return this.idDireccion;
    }
    
    public void setIdDireccion(int idDireccion) {
        this.idDireccion = idDireccion;
    }

    
    @Column(name="idcomite", nullable=false)
    public int getIdcomite() {
        return this.idcomite;
    }
    
    public void setIdcomite(int idcomite) {
        this.idcomite = idcomite;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="usuario")
    public Set getPropuestas() {
        return this.propuestas;
    }
    
    public void setPropuestas(Set propuestas) {
        this.propuestas = propuestas;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="usuario")
    public Set getProyectofts() {
        return this.proyectofts;
    }
    
    public void setProyectofts(Set proyectofts) {
        this.proyectofts = proyectofts;
    }




}


