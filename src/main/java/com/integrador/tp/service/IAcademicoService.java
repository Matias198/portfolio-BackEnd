package com.integrador.tp.service;

import com.integrador.tp.model.Academico;

public interface IAcademicoService {
    public void crearAcademico(Academico academic);
    
    public void borrarAcademico(Long id);
    
    public Academico bucasrAcademico(Long id);
}
