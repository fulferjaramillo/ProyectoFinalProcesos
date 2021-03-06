package CapaDatos;
// Generated 10/07/2015 23:07:03 by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Comite generated by hbm2java
 */
@Entity
@Table(name="comite"
    ,catalog="procesosproyectofinaldb"
)
public class Comite  implements java.io.Serializable {


     private Integer idcomite;
     private Integer director;
     private String docente1;
     private String docente2;
     private String docente3;

    public Comite() {
    }

    public Comite(Integer director, String docente1, String docente2, String docente3) {
       this.director = director;
       this.docente1 = docente1;
       this.docente2 = docente2;
       this.docente3 = docente3;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idcomite", unique=true, nullable=false)
    public Integer getIdcomite() {
        return this.idcomite;
    }
    
    public void setIdcomite(Integer idcomite) {
        this.idcomite = idcomite;
    }

    
    @Column(name="director")
    public Integer getDirector() {
        return this.director;
    }
    
    public void setDirector(Integer director) {
        this.director = director;
    }

    
    @Column(name="docente1", length=11)
    public String getDocente1() {
        return this.docente1;
    }
    
    public void setDocente1(String docente1) {
        this.docente1 = docente1;
    }

    
    @Column(name="docente2", length=50)
    public String getDocente2() {
        return this.docente2;
    }
    
    public void setDocente2(String docente2) {
        this.docente2 = docente2;
    }

    
    @Column(name="docente3", length=11)
    public String getDocente3() {
        return this.docente3;
    }
    
    public void setDocente3(String docente3) {
        this.docente3 = docente3;
    }




}


