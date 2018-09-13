package com.ascentico.statuscode.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins("http://localhost:4201")
                .allowedMethods("POST", "GET")
                .allowedHeaders("Content-Type")
                .allowCredentials(false)
                .maxAge(4800);
    }

}
