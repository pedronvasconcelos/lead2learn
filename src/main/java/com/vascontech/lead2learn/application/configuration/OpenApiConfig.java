package com.vascontech.lead2learn.application.configuration;

import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

import java.util.List;


@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI defineOpenApi() {
        Server server = new Server();
        server.setUrl("http://localhost:8080");
        server.setDescription("Development");


        Contact myContact = new Contact();


        Info information = new Info()
                .title("Lead2Learn API")
                .version("1.0")
                .description("API for Lead2Learn")
                .contact(myContact);
        return new OpenAPI().info(information).servers(List.of(server));

    }

    @Bean
    public GroupedOpenApi crmModule() {
        return GroupedOpenApi.builder()
                .group("CRM")
                .packagesToScan("com.vascontech.lead2learn.crm.web.controllers.v1")
                .pathsToMatch("/crm/**")
                .build();
    }

}