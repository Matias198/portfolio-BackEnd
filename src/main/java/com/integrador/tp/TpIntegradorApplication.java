package com.integrador.tp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TpIntegradorApplication {

    public static void main(String[] args) {
        //SpringApplication.run(TpIntegradorApplication.class, args);
        SpringApplication app = new SpringApplication(TpIntegradorApplication.class);
        app.setDefaultProperties(Collections.singletonMap("server.port", "8443"));
        app.run(args); 
        System.out.println("Backend iniciado");
    }    
}
