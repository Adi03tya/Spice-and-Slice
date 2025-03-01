package com.aditya.web;

import java.io.IOException;
import java.util.List;

import com.aditya.web.DAO.IngredientDAO;
import com.aditya.web.DAO.RecipeDAO;
import com.aditya.web.models.Ingredients;
import com.aditya.web.models.Recipe;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewRecipe
 */
public class ViewRecipe extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ViewRecipe() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int RId = Integer.parseInt( request.getParameter("RID"));
		RecipeDAO recipeDao = new RecipeDAO();
		IngredientDAO  ingredientDao = new IngredientDAO();
		Recipe recipe = recipeDao.getRecipebyId(RId);		
		List<Ingredients> ingredients = ingredientDao.getIngredients(RId);
		
		request.setAttribute("recipe", recipe);
		request.setAttribute("ingredients", ingredients);
		
		RequestDispatcher rd = request.getRequestDispatcher("ViewRecipe.jsp");
		rd.forward(request, response);
		
	}

}
