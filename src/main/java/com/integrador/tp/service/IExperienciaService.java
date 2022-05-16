package com.integrador.tp.service;

import com.integrador.tp.model.Experiencia;

public interface IExperienciaService {
     public void crearExperiencia(Experiencia exp);
    
    public void borrarExperiencia(float id);
    
    public Experiencia bucasrExperiencia(float id);
}
