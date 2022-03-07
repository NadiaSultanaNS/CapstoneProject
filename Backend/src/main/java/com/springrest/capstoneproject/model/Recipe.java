package com.springrest.capstoneproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "recipes")
public class Recipe {
	
	private int recipeId;
	private String recipeTitle;
	@Lob
	private String recipeIngrd;
	@Lob
	private String recipeDesc;
	
	
	
	public Recipe() {
		super();
	}



	public Recipe(int recipeId, String recipeTitle, String recipeIngred, String recipeDescription) {
		super();
		this.recipeId = recipeId;
		this.recipeTitle = recipeTitle;
		this.recipeIngrd = recipeIngred;
		this.recipeDesc = recipeDescription;
	}



	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getRecipeId() {
		return recipeId;
	}



	public String getRecipeTitle() {
		return recipeTitle;
	}



	public void setRecipeTitle(String recipeTitle) {
		this.recipeTitle = recipeTitle;
	}



	public String getRecipeIngrd() {
		return recipeIngrd;
	}



	public void setRecipeIngrd(String recipeIngrd) {
		this.recipeIngrd = recipeIngrd;
	}



	public String getRecipeDesc() {
		return recipeDesc;
	}



	public void setRecipeDesc(String recipeDesc) {
		this.recipeDesc = recipeDesc;
	}



	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}
	
	
	
}
