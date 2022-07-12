
package com.integrador.tp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "academico")
public class Academico implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAcademico;
    //-------------------------
           
    @NotNull private String escuela;
    @NotNull private String titulo;
    @NotNull private String imagen;
    @NotNull private String carrera;
    @NotNull private int puntaje;
    @NotNull private String inicio;
    @NotNull private String fin;
   
    @ManyToOne() 
    @JoinColumn(name = "persona_id", referencedColumnName = "dni") 
    @JsonBackReference 
    @NotNull 
    private Persona persona;
    
}
