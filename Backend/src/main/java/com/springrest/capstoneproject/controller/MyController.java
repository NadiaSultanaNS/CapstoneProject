package com.springrest.capstoneproject.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class MyController {
	
	@GetMapping("/status")
	public String home() {
		return ("Backend server is up and running");
	}
	
}
