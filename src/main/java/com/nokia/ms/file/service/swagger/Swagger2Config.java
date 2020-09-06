package com.nokia.ms.file.service.swagger;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket apiDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.nokia.ms.file.service"))
                .paths(PathSelectors.regex("/.*"))
                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .build()
                .useDefaultResponseMessages(false)
                .apiInfo(apiInfo());
    }

    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Nokia File Service",
                "File related api's are present",
                "1.0",
                "Terms of service",
                new Contact("Syed Waseem", "", "syedwaseemt@gmail.com"),
                "License of API", "", Collections.emptyList());
    }

    @Bean
    public UiConfiguration tryItOutConfig() {
        final String[] methodsWithTryItOutButton = {""};
        return UiConfigurationBuilder.builder().supportedSubmitMethods(methodsWithTryItOutButton).build();
    }

}