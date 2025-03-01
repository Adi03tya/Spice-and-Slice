package com.aditya.web.DAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.aditya.web.dao.DatabaseConnection;
import com.aditya.web.models.Recipe;


public class RecipeDAO {
	
	String url = "jdbc:mysql://localhost:3306/TeluskoJava";
	String userName = "root";
	String password = "admin";
	
	
	public int addRecipe(Recipe r)  {
		
			
		int recipeId = 0;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection	con = DriverManager.getConnection(url,userName,password);
				
				PreparedStatement recipeStmt;
				
					String RecipeQuery = "insert into Recipe (RName, RDescription )  values(?,?)";
					recipeStmt = con.prepareStatement(RecipeQuery, Statement.RETURN_GENERATED_KEYS);
					recipeStmt.setString(1, r.getRecipe_name());
					recipeStmt.setString(2,r.getRecipe_description() );
					recipeStmt.executeUpdate();
					
					ResultSet rs = recipeStmt.getGeneratedKeys();
					
			        if (rs.next()) {
			            recipeId = rs.getInt(1);
			        
			        }
			} catch (SQLException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
				return  recipeId ;
	}
	
	public Recipe getRecipebyId(int RID) {
		Recipe recipe=new Recipe();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con  = DriverManager.getConnection(url,userName,password);
			String query = "Select * from Recipe where RID="+RID;
			Statement st  = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			rs.next();
			recipe = new Recipe(rs.getInt("RID"), rs.getString("RName"),rs.getNString("RDescription"));
			
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return recipe;
	}
	
	public List<Recipe> getALLRecipe() throws SQLException {
//		DatabaseConnection dc = new DatabaseConnection();
//		Connection con = dc.establishConnection();
		List<Recipe> recipeList = new ArrayList<>();
		 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		Connection	con = DriverManager.getConnection(url,userName,password);	
		String query = "select * from recipe";
		Statement st  = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		while(rs.next()) {
			
			Recipe recipe = new Recipe(rs.getInt("RID"), rs.getString("RName"),rs.getNString("RDescription"));
			
			recipeList.add(recipe);
		}
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return recipeList;
		
	}

	
	public List<Recipe> getRecipeByName(String searchQuery) throws SQLException {
//		DatabaseConnection dc = new DatabaseConnection();
//		Connection con = dc.establishConnection();
		List<Recipe> recipeList = new ArrayList<>();
		 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		Connection	con = DriverManager.getConnection(url,userName,password);	
		String query = "select * from recipe where RName = ?";
		PreparedStatement st  = con.prepareStatement(query);
		st.setString (1, searchQuery );
		ResultSet rs = st.executeQuery(query);
		
		while(rs.next()) {
			
			Recipe recipe = new Recipe(rs.getInt("RID"), rs.getString("RName"),rs.getNString("RDescription"));
			
			recipeList.add(recipe);
		}
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
return recipeList;
		
	}
		

}
