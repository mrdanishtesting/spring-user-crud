package com.crud.crudproject;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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

@Configuration
public class SwaggerConfig {

	public static final String AUTHORIZATION_HEADER = "Authorization";

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("public").apiInfo(publicApiInfo())
				.securityContexts(Arrays.asList(securityContext())).securitySchemes(Arrays.asList(apiKey())).select()
				.apis(RequestHandlerSelectors.basePackage("com.crud.crudproject.controller")).paths(PathSelectors.any())
				.build();
	}

	
	  @Bean public Docket privateApi() {
	  
	  return new Docket(DocumentationType.SWAGGER_2).groupName("private").apiInfo(
	  privateApiInfo())
	  .securityContexts(Arrays.asList(securityContext())).securitySchemes(Arrays.
	  asList(apiKey())).select()
	  .apis(RequestHandlerSelectors.basePackage("com.crud.crudproject.admincontroller")).
	  paths(PathSelectors.any()) .build();
	  
	  
	  }
	  
	 
	private ApiKey apiKey() {
		return new ApiKey("JWT", AUTHORIZATION_HEADER, "header");
	}

	private SecurityContext securityContext() {
		return SecurityContext.builder().securityReferences(defaultAuth()).build();
	}

	List<SecurityReference> defaultAuth() {
		AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
		AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
		authorizationScopes[0] = authorizationScope;
		return Arrays.asList(new SecurityReference("JWT", authorizationScopes));
	}

	private ApiInfo publicApiInfo() {
		return new ApiInfo("SPRING-BOOT REST-API",
				"<h3>Danish</h3> <p>We have created an api just need to test an our springboot application ,and in this we can operate functionality of our application like add the user,update the users, we can read the users information and as per our requirements we cqn delete the users",
				"1.0", "Terms of service", new Contact("Arishi", "https://www.arishi.agency", "info@arishi.agency"), "",
				"", Collections.emptyList());
	}
	private ApiInfo privateApiInfo() {
		return new ApiInfo("Thinkfully REST Private API",
				"<h3>Security</h3> <p>We have JWT scurity enabled APIs, so each service (except login and sign-up/registration) would require auth token, which can be created using login service on successful login and we need to pass in request header as Authorization: Bearer [token].",
				"1.0", "Terms of service", new Contact("Arishi", "https://www.arishi.agency", "info@arishi.agency"), "",
				"", Collections.emptyList());
	}

}
