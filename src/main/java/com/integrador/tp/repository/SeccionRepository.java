package com.integrador.tp.repository;

import com.integrador.tp.model.Seccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeccionRepository extends JpaRepository <Seccion, Float>{
    
}
