package com.crud.crudproject.config;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableWebMvc
public class SpringFoxConfig extends WebMvcConfigurerAdapter {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).securityContexts(Arrays.asList())
				.securitySchemes(Arrays.asList()).select()
				.apis(RequestHandlerSelectors.basePackage("com.crud.crudproject.controller"))
				.paths(PathSelectors.any()).build();
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");

		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}

	private ApiInfo apiInfo() {
		return new ApiInfo("SPRING-BOOT REST-API",
				"<h3>Danish</h3> <p>We have created an api just need to test an our springboot application ,and in this we can operate functionality of our application like add the user,update the users, we can read the users information and as per our requirements we cqn delete the users",
				"1.0", "Terms of service", new Contact("Arishi", "https://www.arishi.agency", "info@arishi.agency"), "",
				"", Collections.emptyList());
	}

}