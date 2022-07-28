package com.integrador.tp.controller;

import com.integrador.tp.model.Academico;
import com.integrador.tp.security.dto.Mensaje;
import com.integrador.tp.service.IAcademicoService;
import com.integrador.tp.service.IPersonaService;
import java.net.URISyntaxException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class AcademicoController {

    @Autowired
    private IAcademicoService aServ;
    @Autowired
    private IPersonaService peServ;

    @PostMapping("/crear-academico")
    @ResponseBody
    public ResponseEntity<?> crearAcademico(@RequestBody Academico AcademicoDTO, @RequestParam Long dni) throws URISyntaxException {
        try {
            if (peServ.buscarPersona(dni) != null) {
                AcademicoDTO.setPersona(peServ.buscarPersona(dni));
                aServ.crearAcademico(AcademicoDTO);
                return new ResponseEntity(new Mensaje("Registro exitoso"), HttpStatus.OK);
            }else{
                return new ResponseEntity(new Mensaje("Persona inexistente con DNI: " + dni), HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            return new ResponseEntity(new Mensaje("Error inesperado " + e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/borrar-academico/{id}")
    @ResponseBody
    public ResponseEntity<?> borrarAcademico(@PathVariable(value = "id") Long id) throws URISyntaxException {
        try {
            aServ.borrarAcademico(id);
            return new ResponseEntity(new Mensaje("Eliminado exitosamente"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(new Mensaje("Error inesperado " + e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/modificar-academico/{id}/{dni}")
    @ResponseBody
    public ResponseEntity<?> modificarAcademico(@RequestBody Academico AcademicoDTO, @PathVariable(value = "id") Long id, @PathVariable(value = "dni") Long dni) throws URISyntaxException {
        try {
            AcademicoDTO.setIdAcademico(id);
            AcademicoDTO.setPersona(peServ.buscarPersona(dni));
            aServ.crearAcademico(AcademicoDTO);
            return new ResponseEntity(new Mensaje("Modificado exitosamente"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(new Mensaje("Error inesperado " + e.getMessage()), HttpStatus.BAD_REQUEST);
        }

    }
}
