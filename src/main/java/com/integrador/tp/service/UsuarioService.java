package com.integrador.tp.service;

import com.integrador.tp.model.Usuario;
import com.integrador.tp.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    public UsuarioRepository usrRepo;
    
    @Override
    public void crearUsuario(Usuario usr) {
        usrRepo.save(usr);
    }

    @Override
    public void borrarUsuario(float id) {
        usrRepo.deleteById(id);
    }

    @Override
    public Usuario buscarUsuario(float id) {
        return usrRepo.findById(id).orElse(null);
    }
     
}
