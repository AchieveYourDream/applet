package com.kute.appletmanage.swagger;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

/**
 * @Name: Swagger配置
 * @Description: Swagger配置
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Value("${swagger.enable}")
    private boolean swaggerShow;
    @Bean
    public Docket createRestApi() {
    	
    return new Docket(DocumentationType.SWAGGER_2)
                  .useDefaultResponseMessages(false)
                  .select()
                  .apis(RequestHandlerSelectors.basePackage("com.kute"))
                  .paths(PathSelectors.any())
                  .build()
                  .securitySchemes(securitySchemes())
                  .securityContexts(securityContexts())
                  .enable(swaggerShow)
     			  .apiInfo(apiInfo());  
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("小程序系统管理")
                .description("小程序商品管理接口文档")
                .termsOfServiceUrl("")
                .version("1.0.0")
                .build();
    }
    
    private List<ApiKey> securitySchemes() {
        return newArrayList(
                new ApiKey("Authorization", "Authorization", "header"));
    }

    private List<SecurityContext> securityContexts() {
        return newArrayList(
                SecurityContext.builder()
                        .securityReferences(defaultAuth())
                        .forPaths(PathSelectors.regex("^(?!auth).*$"))
                        .build()
        );
    }

    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return newArrayList(
                new SecurityReference("Authorization", authorizationScopes));
    }



}
