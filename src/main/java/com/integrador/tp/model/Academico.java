
package com.integrador.tp.model;

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
    private float idAcademico;
    //-------------------------
           
    private String escuela;
    private String titulo;
    private String imagen;
    private String carrera;
    private int puntaje;
    private int inicio;
    private int fin;
   
    @ManyToOne()
    @JoinColumn(name = "persona_id")
    private Persona persona;
    
}
