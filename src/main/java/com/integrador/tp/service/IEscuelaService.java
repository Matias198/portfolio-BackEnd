package com.integrador.tp.service;

import com.integrador.tp.model.Escuela;

public interface IEscuelaService {
    public void crearEscuela(Escuela escuela);
    
    public void borrarEscuela(Long id);
    
    public Escuela bucasrEscuela(Long id);
}
