package com.project.recycle.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SpringFoxConfig {
    @Bean
    Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class)).paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()

                .title("Recycling Zones API REST for GLOBANT")
                .description("Spring Boot REST API for final PIL - GLOBANT work.")
                .version("1.0.0")
                .license("Apache 2.0")
                .contact(new Contact("PIL team: Guido Kaloustian - Valentín Giannico - Francisco Caparroz - Denis Tulian", "https://github.com/francaparroz21/TpFinalRecycle", "guidojk96@gmail.com"))
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
                .build();
    }
}

