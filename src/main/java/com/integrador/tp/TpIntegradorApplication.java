package com.integrador.tp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@Configuration
@EnableWebSecurity
public class TpIntegradorApplication {

    public static void main(String[] args) {
        SpringApplication.run(TpIntegradorApplication.class, args);
        System.out.println("Backend iniciado");
    }

    @Bean
    
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("https://porfolio-matias-fernandez.web.app").allowedMethods("*").allowedHeaders("*");
            }
        };
    }
}
