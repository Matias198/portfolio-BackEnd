package com.integrador.tp.controller;

import com.integrador.tp.model.Escuela;
import com.integrador.tp.security.dto.Mensaje;
import com.integrador.tp.service.IEscuelaService;
import com.integrador.tp.service.IPersonaService;
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
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class EscuelaController {

    @Autowired
    private IPersonaService peServ;

    @Autowired
    private IEscuelaService esServ;

    @PostMapping("/crear-escuela")
    @ResponseBody
    public ResponseEntity<?> crearEscuela(@RequestBody Escuela EscuelaDTO, @RequestParam Long dni) throws URISyntaxException {
        try {
            if (peServ.buscarPersona(dni) != null) {
                EscuelaDTO.setPersona(peServ.buscarPersona(dni));
                esServ.crearEscuela(EscuelaDTO);
                return new ResponseEntity(new Mensaje("Registro exitoso"), HttpStatus.OK);
            }else{
                return new ResponseEntity(new Mensaje("Persona inexistente con DNI: " + dni), HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            return new ResponseEntity(new Mensaje("Error inesperado " + e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
    
    @PostMapping("/borrar-escuela/{id}")
    @ResponseBody
    public ResponseEntity<?> borrarEscuela(@PathVariable(value = "id") Long id) throws URISyntaxException {
        try {
            esServ.borrarEscuela(id);
            return new ResponseEntity(new Mensaje("Eliminado exitosamente"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(new Mensaje("Error inesperado " + e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
    
    @PostMapping("/modificar-escuela/{id}/{dni}")
    @ResponseBody
    public ResponseEntity<?> modificarEscuela(@RequestBody Escuela EscuelaDTO, @PathVariable(value = "id") Long id, @PathVariable(value = "dni") Long dni) throws URISyntaxException {
        try {
            EscuelaDTO.setId_escuela(id);
            EscuelaDTO.setPersona(peServ.buscarPersona(dni));
            esServ.crearEscuela(EscuelaDTO);
            return new ResponseEntity(new Mensaje("Modificado exitosamente"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(new Mensaje("Error inesperado " + e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
}
