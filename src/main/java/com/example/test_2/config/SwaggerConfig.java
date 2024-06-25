package com.example.test_2.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .components(new Components().addSecuritySchemes("bearerAuth", new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")))
                .info(new Info().title("Accounting Service API")
                        .description("API specs for accounting service")
                        .version("0.0.1-SNAPSHOT")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }

//    public GroupedOpenApi adminApi(){
//        return GroupedOpenApi.builder().group("admin").pathsToMatch("/admin/**").build();
//    }
//
//    public GroupedOpenApi userApi(){
//        return GroupedOpenApi.builder().group("user").pathsToMatch("/user/**").build();
//    }
}
