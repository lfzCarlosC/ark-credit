package com.cryptal.ark.arkcreditservice;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Configuration
@EnableSwagger2
public class Swagger2 {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .select()
                .apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot")))
                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .build()
                .apiInfo(apiInfo())
                .protocols(protocols())
                .securitySchemes(securitySchemes())
                .securityContexts(securityContexts());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("积分商城")
                .description("积分商城")
                .build();
    }

    private Set<String> protocols() {
        Set<String> protocols = new HashSet<>();
        protocols.add("http");
        return protocols;
    }

    private List<? extends SecurityScheme> securitySchemes() {
        return Collections.<SecurityScheme>singletonList(new ApiKey("token", "token", "query"));
    }

    private List<SecurityContext> securityContexts() {
        return Collections.singletonList(SecurityContext.builder().forPaths(Predicates.not(PathSelectors.regex("/error.*"))).securityReferences(securityReferences()).build());
    }

    private List<SecurityReference> securityReferences() {
        return Collections.singletonList(SecurityReference.builder().reference("token").scopes(new AuthorizationScope[0]).build());
    }
}
