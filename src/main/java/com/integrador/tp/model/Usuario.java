package com.integrador.tp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Usuario implements Serializable {
    @Id
    private Long id_usuario;
    private String password;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "persona_id", referencedColumnName = "dni")
    @JsonBackReference
    private Persona persona;
}
