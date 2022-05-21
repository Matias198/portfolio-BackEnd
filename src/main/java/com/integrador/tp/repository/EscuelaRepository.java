package com.integrador.tp.repository;

import com.integrador.tp.model.Escuela;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EscuelaRepository extends JpaRepository <Escuela, Long> {
    
}
