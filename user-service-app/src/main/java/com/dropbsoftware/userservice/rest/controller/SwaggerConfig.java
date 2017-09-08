package com.dropbsoftware.userservice.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static java.util.Collections.emptyList;
import static springfox.documentation.builders.RequestHandlerSelectors.basePackage;
import static springfox.documentation.service.ApiInfo.DEFAULT_CONTACT;
import static springfox.documentation.swagger.web.UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${info.app.version}")
    private String appVersion;

    @Bean
    public Docket api(@Autowired ApiInfo apiInfo) {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(basePackage("com.dropbsoftware.userservice.rest.controller"))
                .paths(PathSelectors.any())
                .build()
                .directModelSubstitute(LocalDate.class, java.sql.Date.class)
                .directModelSubstitute(LocalDateTime.class, java.util.Date.class)
                .useDefaultResponseMessages(false)
                .apiInfo(apiInfo);
    }

    @Bean
    public ApiInfo apiInfo() {
        return new ApiInfo("User service", "Rest API for user management", appVersion,
                null, DEFAULT_CONTACT, null, null, emptyList());
    }

    @Bean
    public UiConfiguration uiConfiguration() {
        return new UiConfiguration(null, "none", "alpha",
                "schema", DEFAULT_SUBMIT_METHODS, false,
                true, null);
    }
}