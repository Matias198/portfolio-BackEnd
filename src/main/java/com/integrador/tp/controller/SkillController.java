package com.integrador.tp.controller;

import com.integrador.tp.model.Skill;
import com.integrador.tp.security.dto.Mensaje;
import com.integrador.tp.service.IPersonaService;
import com.integrador.tp.service.ISkillService;
import java.net.URISyntaxException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "https://porfolio-matias-fernandez.web.app", methods = {RequestMethod.GET, RequestMethod.POST})
public class SkillController {

    @Autowired
    private IPersonaService peServ;

    @Autowired
    private ISkillService skServ;

    @PostMapping("/crear-skill")
    @ResponseBody
    public ResponseEntity<?> crearSkill(@RequestBody Skill SkillDTO, @RequestParam Long dni) throws URISyntaxException {
        try {
            if (peServ.buscarPersona(dni) != null) {
                SkillDTO.setPersona(peServ.buscarPersona(dni));
                skServ.crearSkill(SkillDTO);
                return new ResponseEntity(new Mensaje("Registro exitoso"), HttpStatus.OK);
            } else {
                return new ResponseEntity(new Mensaje("Persona inexistente con DNI: " + dni), HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            return new ResponseEntity(new Mensaje("Error inesperado " + e.getMessage()), HttpStatus.BAD_REQUEST);
        }  
    }
    
    @PostMapping("/borrar-skill/{id}")
    @ResponseBody
    public ResponseEntity<?> borrarSkill(@PathVariable(value = "id") Long id) throws URISyntaxException {
        try {
            skServ.borrarSkill(id);
            return new ResponseEntity(new Mensaje("Eliminado exitosamente"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(new Mensaje("Error inesperado " + e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
    
    @PostMapping("/modificar-skill/{id}/{dni}")
    @ResponseBody
    public ResponseEntity<?> modificarSkill(@RequestBody Skill SkillDTO, @PathVariable(value = "id") Long id, @PathVariable(value = "dni") Long dni) throws URISyntaxException {
        try {
            SkillDTO.setIdSkill(id);
            SkillDTO.setPersona(peServ.buscarPersona(dni));
            skServ.crearSkill(SkillDTO);
            return new ResponseEntity(new Mensaje("Modificado exitosamente"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(new Mensaje("Error inesperado " + e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
}
