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
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    
    @PostMapping ("/crear-compania")
    public void crearCompania(@ModelAttribute Compania CompaniaDTO, @RequestParam Long dni) throws URISyntaxException {
        if (peServ.buscarPersona(dni) != null){
            CompaniaDTO.setPersona(peServ.buscarPersona(dni));
            cServ.crearCompania(CompaniaDTO);
        }
    }
    
    @PostMapping ("/crear-escuela")
    public void crearEscuela(@ModelAttribute Escuela EscuelaDTO, @RequestParam Long dni) throws URISyntaxException {
        if (peServ.buscarPersona(dni) != null){
            EscuelaDTO.setPersona(peServ.buscarPersona(dni));
            esServ.crearEscuela(EscuelaDTO);
        }
    }
    
    @PostMapping ("/crear-experiencia")
    public void crearExperiencia(@ModelAttribute Experiencia ExperienciaDTO, @RequestParam Long dni) throws URISyntaxException {
        if (peServ.buscarPersona(dni) != null){
            ExperienciaDTO.setPersona(peServ.buscarPersona(dni));
            exServ.crearExperiencia(ExperienciaDTO);
        }
    }
    
    @PostMapping ("/crear-proyecto")
    public void crearProyecto(@ModelAttribute Proyecto ProyectoDTO, @RequestParam Long dni) throws URISyntaxException {
        if (peServ.buscarPersona(dni) != null){
            ProyectoDTO.setPersona(peServ.buscarPersona(dni));
            prServ.crearProyecto(ProyectoDTO);
        }
    }
    
    @PostMapping ("/crear-seccion")
    public void crearSeccion(@ModelAttribute Seccion SeccionDTO, @RequestParam Long dni) throws URISyntaxException {
        if (peServ.buscarPersona(dni) != null){
            SeccionDTO.setPersona(peServ.buscarPersona(dni));
            seServ.crearSeccion(SeccionDTO);
        }
    }
    
    @PostMapping ("/crear-skill")
    public void crearSkill(@ModelAttribute Skill SkillDTO, @RequestParam Long dni) throws URISyntaxException {
        if (peServ.buscarPersona(dni) != null){
            SkillDTO.setPersona(peServ.buscarPersona(dni));
            skServ.crearSkill(SkillDTO);
        }
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
    public Usuario searchUser(@ModelAttribute Usuario UsuarioDTO) throws URISyntaxException {
        if (UsuarioDTO.getPassword().equals(uServ.buscarUsuario(UsuarioDTO.getId_usuario()).getPassword())){
            //UsuarioDTO.setPersona(persoServ.buscarPersona(UsuarioDTO.getId_usuario())); !explota
            return UsuarioDTO;
        }else{
            return null;
        }
    }
    
    @GetMapping ("/portfolio")
    @ResponseBody
    public ResponseEntity<Persona> getPersona(@RequestParam Long dni){
        Persona demo = peServ.buscarPersona(dni);
        Persona perso = new Persona();
        perso.setDni(demo.getDni());
        perso.setNombres(demo.getNombres());
        perso.setApellido(demo.getApellido());
        perso.setFecha_nacimiento(demo.getFecha_nacimiento());
        perso.setNacionalidad(demo.getNacionalidad());
        perso.setMail(demo.getMail());
        perso.setOcupacion(demo.getOcupacion());
        perso.setImage_background(demo.getImage_background());
        perso.setImage_perfil(demo.getImage_perfil());
        
//        List<Experiencia> listaExperiencia;
//        listaExperiencia = demo.getExperiencias();
//        perso.setExperiencias(listaExperiencia);
        return new  ResponseEntity<>(demo, HttpStatus.OK);
    }
    
    @GetMapping ("/ver-experiencias")
    @ResponseBody
    public Persona getExperiencia(@RequestParam Long dni){
//        Persona aux = peServ.buscarPersona(dni);
//        List<Experiencia> listaExperiencias;
//        listaExperiencias = aux.getExperiencias();
//        listaExperiencias.forEach(System.out::println);
        
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
*/
