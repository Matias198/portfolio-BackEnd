package com.integrador.tp.service;

import com.integrador.tp.model.Academico;

public interface IAcademicoService {
    public void crearAcademico(Academico academic);
    
    public void borrarAcademico(float id);
    
    public Academico bucasrAcademico(float id);
}
