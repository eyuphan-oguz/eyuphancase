package com.eyuphancase.eyuphancase.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
    info = @Info(
        contact = @Contact(
            name="enoca Case"
        ),
        description = "Eyüphan Oğuz",
        title = "enoca Challenge"
    ),
    servers = {
        @Server(
            description = "Local ENV",
            url = "http://localhost:8080"
        ),

    }
)

public class OpenApiConfig {
    
}