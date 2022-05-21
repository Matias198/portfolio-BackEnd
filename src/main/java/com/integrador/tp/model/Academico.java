
package com.integrador.tp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
           
    private String escuela;
    private String titulo;
    private String imagen;
    private String carrera;
    private int puntaje;
    private String inicio;
    private String fin;
   
    @ManyToOne()
    @JoinColumn(name = "persona_id", referencedColumnName = "dni")
    @JsonBackReference
    private Persona persona;
    
}
