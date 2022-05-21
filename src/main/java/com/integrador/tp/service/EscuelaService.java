package com.integrador.tp.service;

import com.integrador.tp.model.Escuela;
import com.integrador.tp.repository.EscuelaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EscuelaService implements IEscuelaService {

    @Autowired
    public EscuelaRepository escRepo;

    @Override
    public void crearEscuela(Escuela escuela) {
        escRepo.save(escuela);
    }

    @Override
    public void borrarEscuela(Long id) {
        escRepo.deleteById(id);
    }

    @Override
    public Escuela bucasrEscuela(Long id) {
        return escRepo.findById(id).orElse(null);
    }
    
}
