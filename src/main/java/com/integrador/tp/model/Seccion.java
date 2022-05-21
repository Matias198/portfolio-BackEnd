package com.integrador.tp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Seccion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSeccion;

    private String titulo;
    private String descripcion;
    
    @ManyToOne()
    @JoinColumn(name = "persona_id", referencedColumnName = "dni")
    @JsonBackReference
    private Persona persona;
}