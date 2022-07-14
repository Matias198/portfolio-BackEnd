package com.integrador.tp.security.service;

import com.integrador.tp.security.entity.UsuarioJwt;
import com.integrador.tp.security.repository.URepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UService{
    
    @Autowired
    URepository usuarioRepository;
    
    public Optional<UsuarioJwt> getUsuarioByDni(Long dni){
        return usuarioRepository.findByDniUsuario(dni);
    }
    
    public boolean existsByDni(Long dni){
        return usuarioRepository.existsByDniUsuario(dni);
    }
    
    public void save(UsuarioJwt usuarioJwt){
        usuarioRepository.save(usuarioJwt);
    }
}
