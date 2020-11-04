package com.hyva.idm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tnataraj on 1/15/18.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {

        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.hyva.idm.sass.sassendpoints"))
                .paths(PathSelectors.any())
                .build().globalOperationParameters(buildheaders());
    }

    List<Parameter> buildheaders() {
        ParameterBuilder authPassword = new ParameterBuilder();
        authPassword.name("X-Auth-Password").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        ParameterBuilder authToken = new ParameterBuilder();
        authToken.name("X-Auth-Token").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        ParameterBuilder userName = new ParameterBuilder();
        userName.name("X-Auth-Username").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        List<Parameter> headerParameters = new ArrayList<Parameter>();
        headerParameters.add(authPassword.build());
        headerParameters.add(authToken.build());
        headerParameters.add(userName.build());
        return headerParameters;
    }
}
