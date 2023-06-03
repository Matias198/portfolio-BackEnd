package com.integrador.tp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11NioProtocol;
import org.apache.tomcat.util.net.SSLHostConfig.CertificateVerification;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class CorsConfiguration {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedMethods("*").allowedOrigins("*").allowedHeaders("*");
            }
        };
    }

    final int port = 8443;
    final String cerFile = "ssl/archivo.cer";
    final String keyFile = "ssl/archivo.key";

    @Value("${enviroment.prod}")
    private boolean isProd;

    @Bean
    public TomcatServletWebServerFactory containerFactory() {
        return new TomcatServletWebServerFactory() {
            protected void customizeConnector(Connector connector) {
                super.customizeConnector(connector);
                if (isProd) {
                    int maxSize = 50000000;
                    connector.setMaxPostSize(maxSize);
                    connector.setMaxSavePostSize(maxSize);
                    Http11NioProtocol proto = (Http11NioProtocol) connector.getProtocolHandler();
                    proto.setSSLEnabled(true);
                    proto.setAcceptCount(100);
                    proto.setSslEnabledProtocols("TLSv1,TLSv1.1,TLSv1.2");
                    proto.setMaxThreads(25);
                    proto.setSSLVerifyClient(CertificateVerification.OPTIONAL.toString());
                    proto.setClientAuth(CertificateVerification.NONE.toString());
                    proto.setSSLCertificateFile(cerFile);
                    proto.setSSLCertificateKeyFile(keyFile);

                    connector.setScheme("https");
                    connector.setSecure(true);
                }

            }
        };
    }
    
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    return http
      .requiresChannel(channel -> 
          channel.anyRequest().requiresSecure())
      .authorizeRequests(authorize ->
          authorize.anyRequest().permitAll())
      .build();
    }
}
