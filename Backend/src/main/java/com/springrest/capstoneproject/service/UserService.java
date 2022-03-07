package com.springrest.capstoneproject.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.capstoneproject.model.User;
import com.springrest.capstoneproject.repository.UserRepository;

@Service
@Transactional


public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public List<User> listAllUser(){
		return userRepository.findAll();
	}
	public void saveUser(User user) {
		userRepository.save(user);
	}
	public User getUser(int id) {
		return userRepository.findById(id).get();
	}
	public void deleteUser(int id) {
		userRepository.deleteById(id);
	}
	
}
