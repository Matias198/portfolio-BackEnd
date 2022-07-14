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
@Table(name = "experiencia")
public class Experiencia implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idExperiencia;

    @NotNull private String titulo;
    @NotNull private String establecimiento;
    @NotNull private String lugar;
    @NotNull private String desde;
    @NotNull private String hasta;
    @NotNull private String duracion;
    @NotNull private String ciudad;
    @NotNull private String provincia;
    @NotNull private String pais;
    @NotNull private String imagen;

    @ManyToOne()
    @JoinColumn(name = "persona_id", referencedColumnName = "dni")
    @JsonBackReference
    @NotNull 
    private Persona persona;
}
