<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="com.aditya.web.models.Recipe" %>
<%@page import="com.aditya.web.models.Ingredients" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Recipe</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>

<jsp:include page="navbar.jsp" />

<%
Recipe recipe = (Recipe) request.getAttribute("recipe");
List<Ingredients> ingredients = (List<Ingredients>) request.getAttribute("ingredients");

%>
<div class="container-fluid mt-3" >
<div>
<h2><%= recipe.getRecipe_name() %></h2>

<p><%= recipe.getRecipe_description() %></p>
</div>
<div>
<h4>Ingredients</h4>

<% 
int i=1;
for (Ingredients ingredient:ingredients){
	
		out.println(i + ". " + ingredient.getIngredient()+"\n"); %>
		<br>
		<%
		i++;
	}%>
</div>
</div>
</body>
</html>