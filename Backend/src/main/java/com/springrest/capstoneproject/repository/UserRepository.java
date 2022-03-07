package com.springrest.capstoneproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrest.capstoneproject.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	
	

}
