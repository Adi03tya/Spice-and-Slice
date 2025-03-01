package com.aditya.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.aditya.web.DAO.IngredientDAO;
import com.aditya.web.DAO.RecipeDAO;
import com.aditya.web.models.Ingredients;
import com.aditya.web.models.Recipe;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class SetRecipe
 */

public class SetRecipe extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
    public SetRecipe() {
     
    }
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//			
//	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String recipeName = request.getParameter("recipe_name");
		String recipeDescription = request.getParameter("recipe_description");
		String[] ingredients  =   request.getParameterValues("ingredients[]");
		System.out.println(ingredients);
		 
		Recipe recipe = new Recipe(recipeName,recipeDescription);
		
		RecipeDAO recipeDao = new RecipeDAO();
		int recipeId = recipeDao.addRecipe(recipe);
	
		if ( recipeId !=0 ) {
			IngredientDAO ingredientDao = new IngredientDAO();
			for (String ingredient : ingredients ) {
				Ingredients I = new Ingredients(recipeId, ingredient);
				ingredientDao.addIngredient(I);
				
			}
		}
			
		System.out.println(recipe);
		
		
		response.sendRedirect("ShowRecipe");
	}
	
    

}

