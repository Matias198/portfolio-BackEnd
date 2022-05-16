package com.integrador.tp.model;
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
public class Experiencia implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private float idExperiencia;

    private String titulo;
    private String establecimiento;
    private String lugar;
    private String desde;
    private String hasta;
    private String duracion;
    private String ciudad;
    private String provincia;
    private String pais;
    private String imagen;

    @ManyToOne()
    @JoinColumn(name = "persona_id")
    private Persona persona;
}
