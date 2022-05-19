package com.integrador.tp.service;

import com.integrador.tp.model.Persona;

public interface IPersonaService {
    
    public void crearPersona (Persona per);
    
    public void borrarPersona (Long id);
    
    public Persona buscarPersona (Long id);
    
}
