package com.integrador.tp.security.controller;

import com.integrador.tp.security.dto.JwtDto;
import com.integrador.tp.security.dto.LoginUsuario;
import com.integrador.tp.security.dto.Mensaje;
import com.integrador.tp.security.dto.NuevoUsuario;
import com.integrador.tp.security.entity.Rol;
import com.integrador.tp.security.entity.UsuarioJwt;
import com.integrador.tp.security.enums.RolNombre;
import com.integrador.tp.security.jwt.JwtProvider;
import com.integrador.tp.security.service.RolService;
import com.integrador.tp.security.service.UService;
import com.integrador.tp.service.PersonaService;
import java.util.HashSet;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UService usuarioService;

    @Autowired
    RolService rolService;

    @Autowired
    JwtProvider jwtProvider;

    @Autowired
    PersonaService personaService;

    @PostMapping("/nuevo-usuario")
    public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult) {
        try {
            System.out.println("Verificando errores en los campos");
            if (bindingResult.hasErrors()) {
                return new ResponseEntity(new Mensaje("Error en los campos."), HttpStatus.BAD_REQUEST);
            }
            System.out.println("Verificando usuario dni");
            if (usuarioService.existsByDni(nuevoUsuario.getDni())) {
                return new ResponseEntity(new Mensaje("Dni ya existente."), HttpStatus.BAD_REQUEST);
            }
            System.out.println("Verificando persona dni");
            if (personaService.buscarPersona(nuevoUsuario.getDni()) != null) {
                return new ResponseEntity(new Mensaje("Persona inexistente."), HttpStatus.BAD_REQUEST);  
            } 
            System.out.println("Creando usuario Jwt");
            UsuarioJwt usuario = new UsuarioJwt(nuevoUsuario.getDni(), passwordEncoder.encode(nuevoUsuario.getPassword()), null);
            Set<Rol> roles = new HashSet<>();
            roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());
            if (nuevoUsuario.getRoles().contains("admin")) {
                roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());
            }else if (nuevoUsuario.getRoles().contains("guest")) {
                roles.add(rolService.getByRolNombre(RolNombre.ROLE_GUEST).get());
            }
            usuario.setRoles(roles);
            usuario.setPersona(personaService.buscarPersona(usuario.getDniUsuario()));
            usuarioService.save(usuario);
            return new ResponseEntity(new Mensaje("Usuario guardado."), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(new Mensaje("Error inesperado: " + e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return new ResponseEntity(new Mensaje("Error en los campos."), HttpStatus.BAD_REQUEST);
            }
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUsuario.getDni(), loginUsuario.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtProvider.generateToken(authentication);
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
            return new ResponseEntity(jwtDto, HttpStatus.OK);
        } catch (AuthenticationException e) {
            return new ResponseEntity(new Mensaje("Error inesperado: " + e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
    
    @PostMapping("/nuevo-rol")
    public ResponseEntity<?> nuevoRol(@Valid @RequestBody Rol rol) {
        try {
            if ((rol.getRolNombre().equals(RolNombre.ROLE_ADMIN)) || 
                (rol.getRolNombre().equals(RolNombre.ROLE_GUEST)) || 
                (rol.getRolNombre().equals(RolNombre.ROLE_USER))){
                rolService.save(rol);
                return new ResponseEntity(rol, HttpStatus.OK);
            }else{
                return new ResponseEntity(new Mensaje("El rol ingresado no es valido"), HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            return new ResponseEntity(new Mensaje("Error inesperado: " + e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
    
    @PostMapping("/asociar-persona/{dni}")
    public ResponseEntity<?> asociarPersona(@Valid @PathVariable(value = "dni") Long dni){
        try {
            UsuarioJwt auxiliar = usuarioService.getUsuarioByDni(dni).get();
            auxiliar.setPersona(personaService.buscarPersona(dni));
            usuarioService.save(auxiliar);
            return new ResponseEntity(auxiliar, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(new Mensaje("Error inesperado: " + e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
}
