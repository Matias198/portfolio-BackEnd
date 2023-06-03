package com.integrador.tp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory; 

import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11NioProtocol; 
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.Ssl;
import org.springframework.boot.web.server.SslStoreProvider;

@SpringBootApplication
public class TpIntegradorApplication {

    public static void main(String[] args) {
        SpringApplication.run(TpIntegradorApplication.class, args);
        System.out.println("Backend iniciado");
    }
    
    @Bean
    public TomcatServletWebServerFactory servletContainer() {
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
        // Configuración SSL
        tomcat.addConnectorCustomizers(connector -> {
            connector.setSecure(true);
            connector.setScheme("https");
            connector.setPort(8080); 
            Http11NioProtocol protocol = (Http11NioProtocol) connector.getProtocolHandler();
            protocol.setSSLEnabled(true);
        });

        // Configuración global de SSL
        tomcat.setSsl(getSslConfiguration());

        return tomcat;
    }

    private Ssl getSslConfiguration() {         
        Ssl ssl = new Ssl();
        ssl.setKeyStoreType("PKCS12");
        ssl.setKeyAlias("localhost");
        ssl.setKeyPassword("12345678");
        ssl.setKeyStore("/src/main/resources/keystore.p12");
        ssl.setKeyStorePassword("12345678");
        return ssl;
    } 
    
}
