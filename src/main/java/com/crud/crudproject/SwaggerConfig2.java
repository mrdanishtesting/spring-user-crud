package com.crud.crudproject;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

public class SwaggerConfig2 extends WebMvcConfigurerAdapter {

//	private static final String AUTHORIZATION_HEADER = null;
//
//	@Bean
//	public Docket api() {
//		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).securityContexts(Arrays.asList())
//				.securitySchemes(Arrays.asList()).select()
//				.apis(RequestHandlerSelectors.basePackage("com.crud.crudproject.controller"))
//				.paths(PathSelectors.any()).build();
//	}
//	private ApiKey apiKey() {
//		return new ApiKey("JWT", AUTHORIZATION_HEADER, "header");
//	}
//
//	private SecurityContext securityContext() {
//		return SecurityContext.builder().securityReferences(defaultAuth()).build();
//	}
//
//	List<SecurityReference> defaultAuth() {
//		AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
//		AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
//		authorizationScopes[0] = authorizationScope;
//		return Arrays.asList(new SecurityReference("JWT", authorizationScopes));
//	}
//
//
//	@Override
//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
//
//		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
//	}
//
//	private ApiInfo apiInfo() {
//		return new ApiInfo("SPRING-BOOT REST-API",
//				"<h3>Danish</h3> <p>We have created an api just need to test an our springboot application ,and in this we can operate functionality of our application like add the user,update the users, we can read the users information and as per our requirements we cqn delete the users",
//				"1.0", "Terms of service", new Contact("Arishi", "https://www.arishi.agency", "info@arishi.agency"), "",
//				"", Collections.emptyList());
//	}
//	

}