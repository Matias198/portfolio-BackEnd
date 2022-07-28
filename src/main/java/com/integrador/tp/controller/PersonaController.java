package com.integrador.tp.controller;

import com.integrador.tp.model.Persona;
import com.integrador.tp.security.dto.Mensaje;
import com.integrador.tp.security.service.UService;
import com.integrador.tp.service.IPersonaService;
import java.net.URISyntaxException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
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

    @PutMapping("/modificar-persona/1/{dni}")
    @ResponseBody
    public ResponseEntity<?> modificarPersona(@RequestBody Persona PersonaDTO, @PathVariable(value = "dni") Long dni) throws URISyntaxException {
        try {
            Persona auxiliar = peServ.buscarPersona(dni);
            PersonaDTO.setDni(dni);
            PersonaDTO.setAcademicos(auxiliar.getAcademicos());
            PersonaDTO.setCompania(auxiliar.getCompania());
            PersonaDTO.setEscuela(auxiliar.getEscuela());
            PersonaDTO.setExperiencias(auxiliar.getExperiencias());
            PersonaDTO.setProyectos(auxiliar.getProyectos());
            PersonaDTO.setSecciones(auxiliar.getSecciones());
            PersonaDTO.setSkills(auxiliar.getSkills());
            peServ.crearPersona(PersonaDTO);
            return new ResponseEntity(new Mensaje("Modificado exitosamente"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(new Mensaje("Error inesperado " + e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/portfolio")
    @ResponseBody
    public Persona getPersona(@RequestParam Long dni) {
        if (dni == 1) {
            dni = 41419890L;
        }
        return peServ.buscarPersona(dni);
    }
}
