package com.springrest.capstoneproject.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.capstoneproject.model.Recipe;
import com.springrest.capstoneproject.repository.RecipeRepository;

@Service
@Transactional
public class RecipeService {
	@Autowired
	private RecipeRepository recipeRepository;
	
	
	public List<Recipe> listAllRecipe(){
		return recipeRepository.findAll();
	}
	
	public void saveRecipe(Recipe recipe) {
		recipeRepository.save(recipe);
	}
	
	public Recipe getRecipe(Integer id) {
		return recipeRepository.findById(id).get();
	}
	
	public void deleteRecipe(Integer id) {
		recipeRepository.deleteById(id);
	}
}
