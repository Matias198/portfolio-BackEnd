package com.integrador.tp.security.service;

import com.integrador.tp.security.entity.UsuarioJwt;
import com.integrador.tp.security.entity.UsuarioPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
    
    @Autowired
    UService usuarioService;
    
    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
        UsuarioJwt usuarioJwt = usuarioService.getUsuarioByDni(Long.valueOf(nombreUsuario)).get();
        return UsuarioPrincipal.build(usuarioJwt);
    }
    
}
