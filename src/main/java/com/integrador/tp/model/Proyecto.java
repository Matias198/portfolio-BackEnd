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
@Table(name = "proyecto")
public class Proyecto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private Long idProyecto;
    
    @NotNull private String titulo;
    @NotNull private String descripcion;
    @NotNull private String link;
    
    @ManyToOne()
    @JoinColumn(name = "persona_id", referencedColumnName = "dni")
    @JsonBackReference
    @NotNull 
    private Persona persona;

}
