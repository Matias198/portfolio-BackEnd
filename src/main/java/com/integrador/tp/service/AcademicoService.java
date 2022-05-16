
package com.integrador.tp.service;

import com.integrador.tp.model.Academico;
import com.integrador.tp.repository.AcademicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AcademicoService implements IAcademicoService {
    
    @Autowired
    public AcademicoRepository academicRepo;
     
    @Override
    public void crearAcademico(Academico academic) {
        academicRepo.save(academic);
    }

    @Override
    public void borrarAcademico(float id) {
       academicRepo.deleteById(id);
    }

    @Override
    public Academico bucasrAcademico(float id) {
        return academicRepo.findById(id).orElse(null);
    }
    
}
