package com.integrador.tp.controller;

import com.integrador.tp.model.Persona;
import com.integrador.tp.model.Usuario;
import com.integrador.tp.service.IPersonaService;
import com.integrador.tp.service.IUsuarioService;
import java.net.URISyntaxException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class Controller {
    @Autowired
    private IPersonaService persoServ;
    
    @Autowired
    private IUsuarioService userServ;

    @PostMapping ("/registrar-usuario")
    public void createPromoter(@ModelAttribute Persona PersonaDTO) throws URISyntaxException {
        persoServ.crearPersona(PersonaDTO);
    }
    
    @PostMapping ("/crear-usuario")
    public void createUser(@ModelAttribute Usuario UsuarioDTO, @RequestParam Long dni) throws URISyntaxException {
        UsuarioDTO.setPersona(persoServ.buscarPersona(dni));
        userServ.crearUsuario(UsuarioDTO);
    }
    
    @PostMapping ("/iniciar-sesion")
    public Usuario searchUser(@ModelAttribute Usuario UsuarioDTO) throws URISyntaxException {
        Usuario user = userServ.buscarUsuario(UsuarioDTO.getIdUsuario());
        if (UsuarioDTO.getPassword().equals(user.getPassword())){
            return user;
        }else{
            return null;
        }
    }
}

/*
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url = jdbc:mysql://localhost:3306/tpIntegradorDB?useSSL=false&serverTimezone=UTC
spring.datasource.username=admin
spring.datasource.password=admin
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect


spring.jpa.hibernate.ddl-auto=update
spring.datasource.url = jdbc:mysql://sql10.freesqldatabase.com:3306/sql10493123?useSSL=false&serverTimezone=UTC
spring.datasource.username=sql10493123
spring.datasource.password=MZ6eFhy5jB
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
*/

//persoServ.crearPersona(pers) en @PostMapping
    //persoServ.borrarPersona(id) en @DeleteMapping
    
    
//    @GetMapping ("/inicio/{nombre}")
//    public String decirHola(@PathVariable String nombre){
//        return("Hola Mundo " + nombre);
//    }
//    
//    @GetMapping ("/chau")
//    public String decirChau(@RequestParam String nombre, @RequestParam String apellido, @RequestParam int edad){
//        return ("Chau Mundo " + nombre + " " + apellido + ", edad: " + edad);
//    }
