package com.integrador.tp.service;

import com.integrador.tp.model.Seccion;

public interface ISeccionService {
    public void crearSeccion (Seccion sec);
    
    public void borrarSeccion (Long id);
    
    public Seccion buscarSeccion(Long id);
    
}
