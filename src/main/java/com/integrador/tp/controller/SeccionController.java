package com.integrador.tp.controller;

import com.integrador.tp.model.Seccion;
import com.integrador.tp.security.dto.Mensaje;
import com.integrador.tp.service.IPersonaService;
import com.integrador.tp.service.ISeccionService;
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
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class SeccionController {

    @Autowired
    private IPersonaService peServ;

    @Autowired
    private ISeccionService seServ;

    @PostMapping("/crear-seccion")
    @ResponseBody
    public ResponseEntity<?> crearSeccion(@RequestBody Seccion SeccionDTO, @RequestParam Long dni) throws URISyntaxException {
        try {
            if (peServ.buscarPersona(dni) != null) {
                SeccionDTO.setPersona(peServ.buscarPersona(dni));
                seServ.crearSeccion(SeccionDTO);
                return new ResponseEntity(new Mensaje("Registro exitoso"), HttpStatus.OK);
            } else {
                return new ResponseEntity(new Mensaje("Persona inexistente con DNI: " + dni), HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            return new ResponseEntity(new Mensaje("Error inesperado " + e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/borrar-seccion/{id}")
    @ResponseBody
    public ResponseEntity<?> borrarSeccion(@PathVariable(value = "id") Long id) throws URISyntaxException {
        try {
            seServ.borrarSeccion(id);
            return new ResponseEntity(new Mensaje("Eliminado exitosamente"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(new Mensaje("Error inesperado " + e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/modificar-seccion/{id}/{dni}")
    @ResponseBody
    public ResponseEntity<?> modificarSeccion(@RequestBody Seccion seccionDTO, @PathVariable(value = "id") Long id, @PathVariable(value = "dni") Long dni) throws URISyntaxException {
        try {
            seccionDTO.setIdSeccion(id);
            seccionDTO.setPersona(peServ.buscarPersona(dni));
            seServ.crearSeccion(seccionDTO);
            return new ResponseEntity(new Mensaje("Modificado exitosamente"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(new Mensaje("Error inesperado " + e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
}
