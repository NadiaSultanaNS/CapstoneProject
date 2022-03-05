package com.springrest.capstoneproject;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})


@SpringBootApplication
public class CapstoneprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CapstoneprojectApplication.class, args);
		
	}

}
