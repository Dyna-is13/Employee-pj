package com.example.employee.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.OAuthFlow;
import io.swagger.v3.oas.models.security.OAuthFlows;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static io.swagger.v3.oas.models.security.SecurityScheme.In.HEADER;
import static io.swagger.v3.oas.models.security.SecurityScheme.Type.OAUTH2;

@Configuration
public class SwaggerConfig {
//    @Value("${TOKEN_URL}")
    private String tokenUrl="http://localhost:7777/realms/abcd/protocol/openid-connect/token";
    private static final String OAUTH_TWO = "OAUTH2";

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .components(
                        new Components()
                                .addSecuritySchemes(OAUTH_TWO,
                                        new SecurityScheme()
                                                .type(OAUTH2)
                                                .scheme(OAUTH_TWO)
                                                .in(HEADER)
                                                .flows(new OAuthFlows().password(new OAuthFlow().tokenUrl(tokenUrl)))))
                .addSecurityItem(new SecurityRequirement().addList(OAUTH_TWO));
    }

}
