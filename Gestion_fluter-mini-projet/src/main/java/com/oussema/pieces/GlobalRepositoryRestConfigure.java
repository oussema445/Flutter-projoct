package com.oussema.pieces;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.oussema.pieces.entities.Pieces;
import com.oussema.pieces.entities.User;

@Configuration
public class GlobalRepositoryRestConfigure implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration repositoryRestConfiguration, CorsRegistry cors) {
        // Pour retourner le corps lors de la création et mise à jour
        repositoryRestConfiguration.setReturnBodyOnCreate(true);
        repositoryRestConfiguration.setReturnBodyOnUpdate(true);

        // Exposez les IDs pour les entités de votre projet "pieces"
        repositoryRestConfiguration.exposeIdsFor(Pieces.class, User.class); // Remplacez par les entités réelles

        // Configuration CORS
        cors.addMapping("/**")
            .allowedOrigins("http://localhost:4200", "http://172.20.10.2:8081", "http://localhost:59906") // Ajoutez l'URL de votre frontend Flutter si nécessaire
            .allowedHeaders("*")
            .allowedMethods("OPTIONS", "HEAD", "GET", "PUT", "POST", "DELETE", "PATCH");
    }
}
