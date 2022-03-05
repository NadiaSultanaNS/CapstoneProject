package com.springrest.capstoneproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.capstoneproject.model.Recipe;
import com.springrest.capstoneproject.model.User;
import com.springrest.capstoneproject.service.RecipeService;

@RestController
@RequestMapping("/recipes")
public class RecipeController {
	@Autowired
	RecipeService recipeService;
	
	@GetMapping("")
	public List<Recipe> getAllRecipes(){
		return recipeService.listAllRecipe();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Recipe> getRecipe(@PathVariable Integer id){
		try {
			Recipe recipe = recipeService.getRecipe(id);
					return new ResponseEntity<Recipe>(recipe, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Recipe>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("")
	public void addRecipe(@RequestBody Recipe recipe) {
		recipeService.saveRecipe(recipe);
	}
	@DeleteMapping("/{id}")
	public void deleteRecipe(@PathVariable Integer id) {
		recipeService.deleteRecipe(id);
	}
	
}
