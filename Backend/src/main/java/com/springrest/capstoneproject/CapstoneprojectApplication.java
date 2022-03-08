package com.springrest.capstoneproject;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})


@SpringBootApplication
public class CapstoneprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CapstoneprojectApplication.class, args);
		
	}
	

}
