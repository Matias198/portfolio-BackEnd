package com.integrador.tp.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.integrador.tp.security.entity.UsuarioJwt;
import com.sun.istack.NotNull;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "persona")
public class Persona implements Serializable {
    @Id
    private Long dni;
    @NotNull private String nombres;
    @NotNull private String apellido;
    @NotNull private String fecha_nacimiento;
    @NotNull private String nacionalidad;
    @NotNull private String mail;
    @NotNull private String ocupacion;
    @NotNull private String image_background;
    @NotNull private String image_perfil;
    
    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<Academico> academicos;
    
    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<Experiencia> experiencias;
    
    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<Proyecto> proyectos;
    
    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<Seccion> secciones;
    
    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<Skill> skills;
    
    @OneToOne(mappedBy = "persona", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Compania compania;
    
    @OneToOne(mappedBy = "persona", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Escuela escuela;
    
    @OneToOne(mappedBy = "persona", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private UsuarioJwt usuariojwt;
}
