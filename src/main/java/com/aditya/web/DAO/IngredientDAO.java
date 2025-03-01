package com.aditya.web.DAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.aditya.web.models.Ingredients;
import com.aditya.web.models.Recipe;

public class IngredientDAO {

	String url = "jdbc:mysql://localhost:3306/TeluskoJava";
	String userName = "root";
	String password = "admin";
	
	public void addIngredient(Ingredients I)  {
		
		
		int recipeId = 0;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection	con = DriverManager.getConnection(url,userName,password);
				
				PreparedStatement Stmt;
				
					String Query = "insert into Ingredient ( RecipeId,  Ingredient) values(?,?)";
					Stmt = con.prepareStatement(Query);
					Stmt.setInt(1, I.getRecipeId());
					Stmt.setString(2,I.getIngredient()) ;
					Stmt.executeUpdate();
					
					
			} catch (SQLException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
	}
	
	
	public List<Ingredients> getIngredients(int RID){
		
		List<Ingredients> IngredientsList = new ArrayList<Ingredients> ();
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection	con = DriverManager.getConnection(url,userName,password);
		String Query = "Select * from Ingredient where RecipeId = "+ RID;
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(Query);
		
		while(rs.next()) {
			
			Ingredients ingredient = new Ingredients(RID, rs.getString("Ingredient") );
			System.out.println(ingredient.getIngredient());
			IngredientsList.add(ingredient);
		}
		
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return IngredientsList;
		
		
	}
	
	
}
