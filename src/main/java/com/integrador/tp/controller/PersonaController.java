package com.integrador.tp.controller;

import com.integrador.tp.model.Persona;
import com.integrador.tp.security.dto.Mensaje;
import com.integrador.tp.security.service.UService;
import com.integrador.tp.service.IPersonaService;
import java.net.URISyntaxException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class PersonaController {

    @Autowired
    private IPersonaService peServ;
    
    @Autowired
    private UService uServ;
    
    @PostMapping("/crear-persona")
    @ResponseBody
    public ResponseEntity<?> crearPersona(@RequestBody Persona PersonaDTO) throws URISyntaxException {
        try {
            PersonaDTO.setUsuariojwt(uServ.getUsuarioByDni(PersonaDTO.getDni()).get());
            peServ.crearPersona(PersonaDTO);
            return new ResponseEntity(new Mensaje("Registro exitoso"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(new Mensaje("Error inesperado " + e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/borrar-persona")
    @ResponseBody
    public ResponseEntity<?> borrarPersona(@RequestParam Long dni) throws URISyntaxException {
        try {
            peServ.borrarPersona(dni);
            return new ResponseEntity(new Mensaje("Eliminado exitosamente"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(new Mensaje("Error inesperado " + e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/modificar-persona")
    @ResponseBody
    public ResponseEntity<?> modificarPersona(@RequestBody Persona PersonaDTO, @RequestParam Long dni) throws URISyntaxException {
        try {
            PersonaDTO.setDni(dni);
            peServ.crearPersona(PersonaDTO);
            return new ResponseEntity(new Mensaje("Modificado exitosamente"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(new Mensaje("Error inesperado " + e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
    
    @GetMapping("/portfolio")
    @ResponseBody
    public Persona getPersona(@RequestParam Long dni) {
        if (dni == 1){
            dni = 41419890L;
        }
        return peServ.buscarPersona(dni);
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

spring.jpa.hibernate.ddl-auto=update
spring.datasource.url = jdbc:mysql://bcyrnmnbhoaehisdzisw-mysql.services.clever-cloud.com:3306/bcyrnmnbhoaehisdzisw?useSSL=false&serverTimezone=UTC
spring.datasource.username=uuh0dphvfr9uywnt
spring.datasource.password=9FtmZX2D4aZ7yyQKu8bO
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
 */
