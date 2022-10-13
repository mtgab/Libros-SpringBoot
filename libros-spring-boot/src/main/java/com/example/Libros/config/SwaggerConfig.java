package com.example.Libros.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

/*  Configuración de Swagger para documentar la API REST
*   http://localhost:8080/swagger-ui/
*/

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiDetails())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiDetails() {
        return new ApiInfo("Spring Boot API REST",
                "Documentación",
                "1.0",
                "https://www.google.com",
                new Contact("Gabriela", "https://www.google.com", "google@google.com"),
                "MIT",
                "https://www.google.com",
                Collections.EMPTY_LIST);
    }
}
