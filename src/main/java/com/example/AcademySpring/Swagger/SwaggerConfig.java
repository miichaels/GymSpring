package com.example.AcademySpring.Swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.HashSet;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private Contact contato(){
        return new Contact(
                "Michael",
                "https://portifolio-miichaels.netlify.app/home",
                "michael_araujo2012@hotmail.com"
        );
    }


    public ApiInfoBuilder informacoesAPI() {

        return new ApiInfoBuilder()
                .title("API - Gym")
                .description("Projeto API Spring - Gym Workout")
                .version("4.0.0")
                .license("Miichals")
                .licenseUrl("https://github.com/miichaels")
                .contact(this.contato());
    }


    @Bean
    public Docket detalhesApi() {

        Docket docket = new Docket(DocumentationType.SWAGGER_2);

                docket
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.AcademySpring.Controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(this.informacoesAPI().build())
                        .consumes(new HashSet<String>(Arrays.asList("application/json")))
                        .produces(new HashSet<String>(Arrays.asList("application/json")));
                return docket;
    }

}
