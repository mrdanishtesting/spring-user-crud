package com.crud.crudproject;

import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import com.crud.crudproject.experiment.Box;

@SpringBootApplication
public class CrudProjectApplication implements CommandLineRunner {

	
	
	public static void main(String[] args) {
		
		SpringApplication.run(CrudProjectApplication.class, args);
	}

	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:message");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Override
	public void run(String... args) throws Exception {
		Box box=new Box<String>("hello welcome to my world");
		Box box1=new Box<Integer>(84357363);
		box.performSomeTask();
		box1.performSomeTask();
		
	}
	
	

}
