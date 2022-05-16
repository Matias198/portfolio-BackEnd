
package com.integrador.tp.repository;

import com.integrador.tp.model.Academico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcademicoRepository extends JpaRepository <Academico, Float>{
    
}
