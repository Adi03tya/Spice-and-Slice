package com.aditya.web;

import java.io.IOException;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;
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
 * Servlet implementation class ShowRecipe
 */
public class ShowRecipe extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ShowRecipe() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		String recipeName = request.getParameter("recipe_name");
//		String recipeDescription = request.getParameter("recipe_description");
//		
//		request.setAttribute("recipe_name",recipeName);
//		request.setAttribute("recipe_description", recipeDescription);
		
		RecipeDAO recipeDAO = new RecipeDAO();
		
		try {
			List<Recipe> recipes = recipeDAO.getALLRecipe();
//			request.setAttribute("recipes", recipes);
			
			LinkedHashMap <Recipe, List<Ingredients>> map =  new LinkedHashMap<>();
			
			for (Recipe recipe : recipes) {
				IngredientDAO ingredientDAO = new IngredientDAO();
				List<Ingredients> ingredients=  ingredientDAO.getIngredients(recipe.getRID());
				map.put(recipe, ingredients);
				
			}
			
			request.setAttribute("recipeMap", map);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher rd  =  request.getRequestDispatcher("showRecipe.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
