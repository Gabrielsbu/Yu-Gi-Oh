package com.todos.core;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Documentation {

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Yu-Gi-Oh X")
                        .description("Conheça as principais cartas, personagens e Decks de Yu-Gi-Oh X")
                        .version("v1.0.0"));
    }
}
