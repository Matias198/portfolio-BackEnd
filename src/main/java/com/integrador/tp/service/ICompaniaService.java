package com.integrador.tp.service;

import com.integrador.tp.model.Compania;

public interface ICompaniaService {
     public void crearCompania(Compania compania);
    
    public void borrarCompania(Long id);
    
    public Compania bucasrCompania(Long id);
}
