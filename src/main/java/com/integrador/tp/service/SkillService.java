package com.integrador.tp.service;

import com.integrador.tp.model.Skill;
import com.integrador.tp.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillService  implements ISkillService{
    @Autowired
    public SkillRepository skillRepo;

    @Override
    public void crearSkill(Skill skill) {
        skillRepo.save(skill);}

    @Override
    public void borrarSkill(Long id) {
        skillRepo.deleteById(id);
    }

    @Override
    public Skill buscarSkill(Long id) {
        return skillRepo.findById(id).orElse(null);
    }
}
