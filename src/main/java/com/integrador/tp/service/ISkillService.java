package com.integrador.tp.service;

import com.integrador.tp.model.Skill;

public interface ISkillService {
    
    public void crearSkill (Skill skill);
    
    public void borrarSkill (Long id);
    
    public Skill buscarSkill (Long id);
}
