package com.integrador.tp.service;

import com.integrador.tp.model.Proyecto;

public interface IProyectoService {
    public void crearProyecto (Proyecto pro);
    
    public void borrarProyecto (float id);
    
    public Proyecto buscarProyecto(float id);
    
}
