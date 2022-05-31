package com.integrador.tp.controller;

import com.integrador.tp.model.Academico;
import com.integrador.tp.model.Compania;
import com.integrador.tp.model.Escuela;
import com.integrador.tp.model.Experiencia;
import com.integrador.tp.model.Persona;
import com.integrador.tp.model.Proyecto;
import com.integrador.tp.model.Seccion;
import com.integrador.tp.model.Skill;
import com.integrador.tp.model.Usuario;
import com.integrador.tp.service.IAcademicoService;
import com.integrador.tp.service.ICompaniaService;
import com.integrador.tp.service.IEscuelaService;
import com.integrador.tp.service.IExperienciaService;
import com.integrador.tp.service.IPersonaService;
import com.integrador.tp.service.IProyectoService;
import com.integrador.tp.service.ISeccionService;
import com.integrador.tp.service.ISkillService;
import com.integrador.tp.service.IUsuarioService;
import java.net.URISyntaxException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class Controller {
    @Autowired
    private IPersonaService peServ;
    
    @Autowired
    private IUsuarioService uServ;
    
    @Autowired
    private IAcademicoService aServ;
    
    @Autowired
    private ICompaniaService cServ;

    @Autowired
    private IEscuelaService esServ;
    
    @Autowired
    private IExperienciaService exServ;
    
    @Autowired
    private IProyectoService prServ;
    
    @Autowired
    private ISeccionService seServ;
    
    @Autowired
    private ISkillService skServ;
    
    @PostMapping ("/crear-academico")
    public void crearAcademico(@ModelAttribute Academico AcademicoDTO, @RequestParam Long dni) throws URISyntaxException {
        if (peServ.buscarPersona(dni) != null){
            AcademicoDTO.setPersona(peServ.buscarPersona(dni));
            aServ.crearAcademico(AcademicoDTO);
        }
    }
    
    @PostMapping ("/borrar-academico")
    public void borrarAcademico(@RequestParam Long id) throws URISyntaxException {
        aServ.borrarAcademico(id);   
    }
    
    @PostMapping ("/crear-compania")
    public void crearCompania(@ModelAttribute Compania CompaniaDTO, @RequestParam Long dni) throws URISyntaxException {
        if (peServ.buscarPersona(dni) != null){
            CompaniaDTO.setPersona(peServ.buscarPersona(dni));
            cServ.crearCompania(CompaniaDTO);
        }
    }
    
    @PostMapping ("/borrar-compania")
    public void borrarCompania(@RequestParam Long id) throws URISyntaxException {
        cServ.borrarCompania(id);
        
    }
    
    @PostMapping ("/crear-escuela")
    public void crearEscuela(@ModelAttribute Escuela EscuelaDTO, @RequestParam Long dni) throws URISyntaxException {
        if (peServ.buscarPersona(dni) != null){
            EscuelaDTO.setPersona(peServ.buscarPersona(dni));
            esServ.crearEscuela(EscuelaDTO);
        }
    }
    
    @PostMapping ("/borrar-escuela")
    public void borrarEscuela(@RequestParam Long id) throws URISyntaxException {
        esServ.borrarEscuela(id);
        
    }
    
    @PostMapping ("/crear-experiencia")
    public void crearExperiencia(@ModelAttribute Experiencia ExperienciaDTO, @RequestParam Long dni) throws URISyntaxException {
        if (peServ.buscarPersona(dni) != null){
            ExperienciaDTO.setPersona(peServ.buscarPersona(dni));
            exServ.crearExperiencia(ExperienciaDTO);
        }
    }
    
    @PostMapping ("/borrar-experiencia")
    public void borrarExperiencia(@RequestParam Long id) throws URISyntaxException {
        exServ.borrarExperiencia(id);
        
    }
    
    @PostMapping ("/crear-proyecto")
    public void crearProyecto(@ModelAttribute Proyecto ProyectoDTO, @RequestParam Long dni) throws URISyntaxException {
        if (peServ.buscarPersona(dni) != null){
            ProyectoDTO.setPersona(peServ.buscarPersona(dni));
            prServ.crearProyecto(ProyectoDTO);
        }
    }
    
    @PostMapping ("/borrar-proyecto")
    public void borrarProyecto(@RequestParam Long id) throws URISyntaxException {
        prServ.borrarProyecto(id);
    }
    
    @PostMapping ("/crear-seccion")
    public void crearSeccion(@ModelAttribute Seccion SeccionDTO, @RequestParam Long dni) throws URISyntaxException {
        if (peServ.buscarPersona(dni) != null){
            SeccionDTO.setPersona(peServ.buscarPersona(dni));
            seServ.crearSeccion(SeccionDTO);
        }
    }
    
    @PostMapping ("/borrar-seccion")
    public void borrarSeccion(@RequestParam Long id) throws URISyntaxException {
        seServ.borrarSeccion(id);
    }
    
    @PostMapping ("/crear-skill")
    public void crearSkill(@ModelAttribute Skill SkillDTO, @RequestParam Long dni) throws URISyntaxException {
        if (peServ.buscarPersona(dni) != null){
            SkillDTO.setPersona(peServ.buscarPersona(dni));
            skServ.crearSkill(SkillDTO);
        }
    }
    
    @PostMapping ("/borrar-skill")
    public void borrarSkill(@RequestParam Long id) throws URISyntaxException {
        skServ.borrarSkill(id);
        
    }
    
    @PostMapping ("/crear-persona")
    public void crearPersona(@ModelAttribute Persona PersonaDTO) throws URISyntaxException {
        peServ.crearPersona(PersonaDTO);
    }
    
    @PostMapping ("/crear-usuario")
    public void crearUsuario(@ModelAttribute Usuario UsuarioDTO) throws URISyntaxException {
        if (peServ.buscarPersona(UsuarioDTO.getId_usuario()) != null){
            UsuarioDTO.setPersona(peServ.buscarPersona(UsuarioDTO.getId_usuario()));
            uServ.crearUsuario(UsuarioDTO);
        }
    }
        
    @PostMapping ("/iniciar-sesion")
    @ResponseBody
    public Usuario searchUser(@RequestParam Long id_usuario, @RequestParam String password) throws URISyntaxException {
        
        //Obtengo la Persona del user
        Persona perso = peServ.buscarPersona(id_usuario);
        
        //Obtener el Usuario del UsuarioDTO
        Usuario user = perso.getUsuario();
        
        if (user.getId_usuario().equals(id_usuario)){
            if (user.getPassword().equals(password)){
                return user;
            }else{
                return null;
            }
        }else{
            return null;
        }
        
        
        

//        UsuarioDTO.setId_usuario(Long.MIN_VALUE);
//        Usuario user = uServ.buscarUsuario(UsuarioDTO.getId_usuario());
//        if (user != null){
//            Persona perso = user.getPersona();
//            Long id_usuario = perso.getUsuario().getId_usuario();
//            String password = perso.getUsuario().getPassword();
//            if (UsuarioDTO.getId_usuario().equals(id_usuario) && UsuarioDTO.getPassword().equals(password)){
//                return perso.getUsuario();
//            }else{
//                return null;
//            }
//        }else{
//            return null;
//        }
    }
    
    @GetMapping ("/portfolio")
    @ResponseBody
    public Persona getPersona(@RequestParam Long dni){
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
