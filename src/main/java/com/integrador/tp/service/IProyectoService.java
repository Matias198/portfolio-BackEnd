package com.integrador.tp.service;

import com.integrador.tp.model.Proyecto;

public interface IProyectoService {
    public void crearProyecto (Proyecto pro);
    
    public void borrarProyecto (Long id);
    
    public Proyecto buscarProyecto(Long id);
    
}
