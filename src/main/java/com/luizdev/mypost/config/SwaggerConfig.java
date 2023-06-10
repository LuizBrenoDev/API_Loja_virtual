package com.luizdev.mypost.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    
    @Bean
    public GroupedOpenApi publicAPI(){
        return GroupedOpenApi.builder().group("apilojadigital-public").pathsToMatch("/users/**", "/products/**", "/sellers/**").build();
    };
    
}
