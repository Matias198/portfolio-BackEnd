package com.integrador.tp.service;

import com.integrador.tp.model.Experiencia;

public interface IExperienciaService {
     public void crearExperiencia(Experiencia exp);
    
    public void borrarExperiencia(Long id);
    
    public Experiencia bucasrExperiencia(Long id);
}
