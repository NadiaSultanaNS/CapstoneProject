package com.springrest.capstoneproject.repository;


import org.springframework.data.jpa.repository.JpaRepository;


import com.springrest.capstoneproject.model.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
	

}
