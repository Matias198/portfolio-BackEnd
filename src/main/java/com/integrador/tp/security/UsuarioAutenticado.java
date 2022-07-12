
package com.integrador.tp.security;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UsuarioAutenticado {
   private String id_usuario;
   private String password;
   private String token;
}
