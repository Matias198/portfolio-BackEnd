package com.integrador.tp.service;

import com.integrador.tp.model.Seccion;
import com.integrador.tp.repository.SeccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeccionService implements ISeccionService{
    @Autowired
    public SeccionRepository seccionRepo;

    @Override
    public void crearSeccion(Seccion sec) {
        seccionRepo.save(sec);
    }

    @Override
    public void borrarSeccion(float id) {
        seccionRepo.deleteById(id);
    }

    @Override
    public Seccion buscarSeccion(float id) {
        return seccionRepo.findById(id).orElse(null);
    }
    
}
