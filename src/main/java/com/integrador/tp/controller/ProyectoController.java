package com.integrador.tp.controller;

import com.integrador.tp.model.Proyecto;
import com.integrador.tp.security.dto.Mensaje;
import com.integrador.tp.service.IPersonaService;
import com.integrador.tp.service.IProyectoService;
import java.net.URISyntaxException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProyectoController {

    @Autowired
    private IPersonaService peServ;
    @Autowired
    private IProyectoService prServ;

    @PostMapping("/crear-proyecto")
    @ResponseBody
    public ResponseEntity<?> crearProyecto(@RequestBody Proyecto ProyectoDTO, @RequestParam Long dni) throws URISyntaxException {
        try {
            if (peServ.buscarPersona(dni) != null) {
                ProyectoDTO.setPersona(peServ.buscarPersona(dni));
                prServ.crearProyecto(ProyectoDTO);
                return new ResponseEntity(new Mensaje("Registro exitoso"), HttpStatus.OK);
            } else {
                return new ResponseEntity(new Mensaje("Persona inexistente con DNI: " + dni), HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            return new ResponseEntity(new Mensaje("Error inesperado " + e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/borrar-proyecto/{id}")
    @ResponseBody
    public ResponseEntity<?> borrarProyecto(@PathVariable(value = "id") Long id) throws URISyntaxException {
        try {
            prServ.borrarProyecto(id);
            return new ResponseEntity(new Mensaje("Eliminado exitosamente"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(new Mensaje("Error inesperado " + e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/modificar-proyecto/{id}/{dni}")
    @ResponseBody
    public ResponseEntity<?> modificarProyecto(@RequestBody Proyecto ProyectoDTO, @PathVariable(value = "id") Long id, @PathVariable(value = "dni") Long dni) throws URISyntaxException {
        try {
            ProyectoDTO.setIdProyecto(id);
            ProyectoDTO.setPersona(peServ.buscarPersona(dni));
            prServ.crearProyecto(ProyectoDTO);
            return new ResponseEntity(new Mensaje("Modificado exitosamente"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(new Mensaje("Error inesperado " + e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
}
