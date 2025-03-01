package com.aditya.web.models;

import java.util.Arrays;
import java.util.List;

public class Recipe {
	
	private int RID;
	private String Recipe_name;
	private String Recipe_description;

	
	public Recipe() {
		
	}
	public Recipe(int RID, String Recipe_name, String Recipe_description ) {
		this.RID = RID;
		this.Recipe_name = Recipe_name;
		this.Recipe_description = Recipe_description;
	};
	
	public int getRID() {
		return RID;
	}

	public void setRID(int rID) {
		RID = rID;
	}

	public Recipe( String Recipe_name, String Recipe_description ) {
//		this.RId = RId;
		this.Recipe_name = Recipe_name;
		this.Recipe_description = Recipe_description;
		
	}
	
	
	public String getRecipe_name() {
		return Recipe_name;
	}
	public void setRecipe_name(String recipe_name) {
		Recipe_name = recipe_name;
	}
	public String getRecipe_description() {
		return Recipe_description;
	}
	public void setRecipe_description(String recipe_description) {
		Recipe_description = recipe_description;
	}
	@Override
	public String toString() {
		return "Recipe [ Recipe_name=" + Recipe_name + ", Recipe_description=" + Recipe_description
				+  "]";
	}
	
	
	

}
