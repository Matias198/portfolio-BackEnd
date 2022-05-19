package com.integrador.tp.service;

import com.integrador.tp.model.Usuario;

public interface IUsuarioService {
    
    public void crearUsuario (Usuario usr);
    
    public void borrarUsuario (Long id);
    
    public Usuario buscarUsuario(Long id);
}
