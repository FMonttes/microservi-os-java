package com.microservices.pedidos_api.conifg;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocOpenApiConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(
                        new Info()
                                .title("Spring Doc API")
                                .description("API para realização de pedidos")
                                .license(new License().name("Apache 2.0"))
                                .contact(new Contact().name("felipe montes").email("felipe.montes100@gmail.com"))
                );

    }
}
