<%@page import="com.google.protobuf.Value"%>
<%@page import="java.util.*" %>
<%@page import="com.aditya.web.models.Recipe" %>
<%@page import="com.aditya.web.models.Ingredients" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>

<%

/* List<Recipe> recipes =(List<Recipe>) request.getAttribute("recipes"); */
LinkedHashMap<Recipe,List<Ingredients>> recipeMap = (LinkedHashMap<Recipe,List<Ingredients>>)request.getAttribute("recipeMap");
System.out.println(recipeMap);
       
%>

 
<jsp:include page="navbar.jsp" />

<table class="table">
    <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Recipe Name</th>
            <th scope="col">Recipe Description</th>
            <!-- <th scope="col">Ingredients</th>  -->
            <th scope="col"> Action </th>
        </tr>
    </thead>
    <tbody>
        <% 
        // Use a simple for loop to iterate over the recipes list
         for (Map.Entry<Recipe,List<Ingredients> > me :
             recipeMap.entrySet()) {

            Recipe recipe = me.getKey();
            List < Ingredients> ingredients = me.getValue();
        	int RID = recipe.getRID();
        %>
        <tr>
            <th scope="row"><%= recipe.getRID() %></th>  <!-- Print recipe ID -->
            <td><%= recipe.getRecipe_name() %></td>      <!-- Print recipe name -->
            <td><%= recipe.getRecipe_description() %></td> <!-- Print recipe description -->
            <%-- <td><% int count =1;
            for(Ingredients ingredient:ingredients){
            	 out.println(count + ". "+ ingredient.getIngredient());
            	 out.println("\n");
            	 count++;}
            %></td> --%>
            <td><form action="viewRecipe">
            		<input type="hidden" name="RID" value="<%= recipe.getRID() %>">
            		
            		<button type="submit" class="btn btn-success">View</button>
            		
            </form> </td>
         
           
        </tr>
        <% } %>  <!-- End of for loop -->
    </tbody>
</table>
</body>
</html>