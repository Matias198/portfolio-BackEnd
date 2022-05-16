package com.integrador.tp.service;

import com.integrador.tp.model.Proyecto;
import com.integrador.tp.repository.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProyectoService implements IProyectoService{

    @Autowired
    public ProyectoRepository proRepo;
    
    @Override
    public void crearProyecto(Proyecto pro) {
       proRepo.save(pro);
    }

    @Override
    public void borrarProyecto(float id) {
        proRepo.deleteById(id);
    }

    @Override
    public Proyecto buscarProyecto(float id) {
        return proRepo.findById(id).orElse(null);
    }
    
}
