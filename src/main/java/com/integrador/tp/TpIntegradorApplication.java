package com.integrador.tp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TpIntegradorApplication {

    public static void main(String[] args) {
        SpringApplication.run(TpIntegradorApplication.class, args);
        System.out.println("Backend iniciado");
    }
    
    @Bean
    public EmbeddedServletContainerFactory servletContainer() {
        TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory() {
            @Override
            protected void customizeConnector(Connector connector) {
                super.customizeConnector(connector);
                connector.setPort(8443);
                connector.setSecure(true);
                connector.setScheme("https");
                Http11NioProtocol protocol = (Http11NioProtocol) connector.getProtocolHandler();
                protocol.setSSLEnabled(true);
                protocol.setKeystoreFile("/src/main/resources/keystore.p12"); // Ruta al archivo del certificado
                protocol.setKeystorePass("12345678"); // Contraseña del certificado
                protocol.setKeystoreType("PKCS12");
                protocol.setKeyAlias("user"); // Alias del certificado
            }
        };

        return factory;
    }

}
