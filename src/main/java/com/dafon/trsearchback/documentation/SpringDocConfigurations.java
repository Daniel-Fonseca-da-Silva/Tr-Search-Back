package com.dafon.trsearchback.documentation;

import io.swagger.v3.oas.models.*;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.*;

@Configuration
public class SpringDocConfigurations {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("bearer-key",
                                new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")));
    }

}
