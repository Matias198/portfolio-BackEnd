package com.integrador.tp.service;

import com.integrador.tp.model.Usuario;

public interface IUsuarioService {
    
    public void crearUsuario (Usuario usr);
    
    public void borrarUsuario (float id);
    
    public Usuario buscarUsuario(float id);
}
