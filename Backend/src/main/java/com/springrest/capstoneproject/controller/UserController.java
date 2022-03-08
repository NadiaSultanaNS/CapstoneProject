package com.springrest.capstoneproject.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.capstoneproject.model.User;
import com.springrest.capstoneproject.service.UserService;
@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	UserService userService;
	@GetMapping("")
	public List<User> getAllUsers(){
		return userService.listAllUser();
	}
	
}
