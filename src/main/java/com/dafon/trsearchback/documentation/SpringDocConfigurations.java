package com.dafon.trsearchback.documentation;

import io.swagger.v3.oas.models.*;
import io.swagger.v3.oas.models.info.*;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.*;

@Configuration
public class SpringDocConfigurations {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("bearer-key",
                                new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")))
                .info(new Info()
                        .title("TR-Search API")
                        .description("A back end project created by Dafon company to search business by area")
                        .contact(new Contact()
                                .name("Dafon")
                                .email("daniel117fonseca@gmail.com")
                                .url("https://dafon.dev"))
                        .license(new License()
                                .name("MIT")
                                .url("https://github.com/Daniel-Fonseca-da-Silva/Tr-Search-Back/blob/master/LICENSE.txt"))
                );
    }

}
