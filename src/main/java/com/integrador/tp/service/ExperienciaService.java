package com.integrador.tp.service;

import com.integrador.tp.model.Experiencia;
import com.integrador.tp.repository.ExperienciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienciaService implements IExperienciaService{
    
    @Autowired
    public ExperienciaRepository expRepo;
    
    @Override
    public void crearExperiencia(Experiencia exp) {
        expRepo.save(exp);
    }

    @Override
    public void borrarExperiencia(Long id) {
        expRepo.deleteById(id);
    }

    @Override
    public Experiencia bucasrExperiencia(Long id) {
        return expRepo.findById(id).orElse(null);
    }
    
}
