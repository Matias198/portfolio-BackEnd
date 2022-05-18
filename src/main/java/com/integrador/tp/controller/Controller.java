package com.integrador.tp.controller;

import com.integrador.tp.model.Persona;
import com.integrador.tp.service.IPersonaService;
import java.net.URISyntaxException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    private IPersonaService persoServ;


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
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping ("/registrar-usuario")
    public void createPromoter(@ModelAttribute Persona PersonaDTO) throws URISyntaxException { 
          persoServ.crearPersona(PersonaDTO);
    }
}

/*
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url = jdbc:mysql://localhost:3306/tpIntegradorDB?useSSL=false&serverTimezone=UTC
spring.datasource.username=admin
spring.datasource.password=admin
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
*/
