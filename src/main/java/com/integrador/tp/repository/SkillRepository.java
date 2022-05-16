package com.integrador.tp.repository;

import com.integrador.tp.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository <Skill, Float>{
    
}
