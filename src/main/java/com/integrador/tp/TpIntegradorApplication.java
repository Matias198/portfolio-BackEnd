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
        tomcat.addConnectorCustomizers((TomcatConnectorCustomizer) connector -> {
            connector.setPort(8443);
            connector.setSecure(true);
            connector.setScheme("https");

            Http11NioProtocol protocol = (Http11NioProtocol) connector.getProtocolHandler();
            protocol.setSSLEnabled(true);
            protocol.setKeystorePass("12345678"); // Contraseña del certificado
            protocol.setKeystoreType("PKCS12");

            // Configuración personalizada para obtener el certificado y la clave privada
            protocol.setSslProtocol("TLS");
            protocol.setKeystoreFile("/src/main/resources/keystore.p12"); // Ruta al archivo del certificado
            protocol.setKeyAlias("localhost"); // Alias del certificado
            protocol.setKeyPass("12345678"); // Contraseña del alias

            // Opcional: Configurar proveedor de almacenamiento SSL personalizado si es necesario
            // protocol.setSslStoreProvider(new CustomSslStoreProvider());

            // Opcional: Configurar algoritmo de clave personalizado si es necesario
            // protocol.setKeyManagerAlgorithm("SunX509");

            // Opcional: Configurar la lista de protocolos SSL permitidos
            // protocol.setCiphers("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256,TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256");

            // Opcional: Configurar la lista de suites de cifrado SSL permitidas
            // protocol.setCipherSuite("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256");

            // Opcional: Configurar el proveedor de seguridad personalizado si es necesario
            // protocol.setProvider("SunJSSE");
        });

        // Opcional: Configurar SSL globalmente para todos los conectores (HTTP y HTTPS)
        tomcat.setSsl(getSslConfiguration());
        return tomcat;
    }

    // Opcional: Configurar SSL globalmente para todos los conectores (HTTP y HTTPS)
    private Ssl getSslConfiguration() {
        Ssl ssl = new Ssl();
        ssl.setKeyStoreType("PKCS12");
        ssl.setKeyAlias("localhost");
        ssl.setKeyPassword("12345678");
        ssl.setKeyStore("classpath:keystore.p12");
        ssl.setKeyStorePassword("12345678");
        return ssl;
    }

    // Opcional: Implementar SslStoreProvider personalizado si se necesita un proveedor de almacenamiento SSL personalizado
    private class CustomSslStoreProvider implements SslStoreProvider {
        // Implementar los métodos necesarios para cargar el certificado y la clave privada de una ubicación personalizada
    }
    
}
