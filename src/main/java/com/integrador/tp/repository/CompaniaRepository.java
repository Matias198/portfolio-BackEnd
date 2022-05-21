package com.integrador.tp.repository;

import com.integrador.tp.model.Compania;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompaniaRepository extends JpaRepository <Compania, Long>{
    
}
