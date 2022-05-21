
package com.integrador.tp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@Entity
@Table(name = "compania")
public class Compania implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_compania;
    
    private String nombre;
    private String imagen;
    private String url;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "persona_id", referencedColumnName = "dni")
    @JsonBackReference
    private Persona persona;
}
