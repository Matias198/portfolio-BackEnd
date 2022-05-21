package com.integrador.tp.service;

import com.integrador.tp.model.Compania;
import com.integrador.tp.repository.CompaniaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CompaniaService implements ICompaniaService{
    
    @Autowired
    public CompaniaRepository compRepo;
    
    @Override
    public void crearCompania(Compania compania) {
        compRepo.save(compania);
    }

    @Override
    public void borrarCompania(Long id) {
        compRepo.deleteById(id);
    }

    @Override
    public Compania bucasrCompania(Long id) {
        return compRepo.findById(id).orElse(null);
    }
    
}
