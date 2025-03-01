package com.aditya.web.models;

public class Ingredients {

	private int RecipeId;
	String Ingredient;
	public Ingredients(int recipeId, String ingredient) {
		// TODO Auto-generated constructor stub
		this.RecipeId = recipeId;
		this.Ingredient = ingredient;
	}
	public int getRecipeId() {
		return RecipeId;
	}
	public void setRecipeId(int recipeId) {
		RecipeId = recipeId;
	}
	public String getIngredient() {
		return Ingredient;
	}
	public void setIngredient(String ingredient) {
		Ingredient = ingredient;
	}
	@Override
	public String toString() {
		return "Ingredients [RecipeId=" + RecipeId + ", Ingredient=" + Ingredient + "]";
	}
}
