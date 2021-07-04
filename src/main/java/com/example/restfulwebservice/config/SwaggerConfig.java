package com.example.restfulwebservice.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private static final Contact DEFAULT_CONTACT = new Contact("Dong Wook Lee", "https://dongwooklee96.github.io/",
        "sh95119@gmail.com");

    private static final ApiInfo DEFAULT_API_INFO = new ApiInfo("Awesome API Title",
    "My User management REST API service", "1.0", "urn:tos",
        DEFAULT_CONTACT, "Apache 2.0", "https://apache.org/licenses/LICENSE-2.0", new ArrayList<>());

    private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = new HashSet<>(
        Arrays.asList("application/json", "application/xml"));

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30)
            .select()
            .apis(RequestHandlerSelectors.any())
            .paths(PathSelectors.any())
            .build()
            .apiInfo(DEFAULT_API_INFO)
            .produces(DEFAULT_PRODUCES_AND_CONSUMES)
            .consumes(DEFAULT_PRODUCES_AND_CONSUMES);
    }
}