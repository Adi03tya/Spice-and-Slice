<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg  bg-primary">
  <div class="container-fluid">
  	  <img class="img" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTEbJDOAToS_KKdEgEw4JE-_s8sNFH2RrS2ag&s" style="width:50px; height:50px; border-radius: 50%; object-fit: cover; margin-right:10px;">
    <a class="navbar-brand" href="#" style="color:white; "> <h3> Spice & Slice </h3></a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" style="color:white;" href="index.jsp">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" style="color:white;" href="index.jsp">Add Recipe</a>
        </li>
       
        <li class="nav-item">
          <a class="nav-link active" style="color:white;" href="ShowRecipe" >View Recipe</a>
        </li>
      </ul>
      <form class="d-flex" role="search" action="SearchRecipe" method="get"  >
        <input class="form-control me-2" name = "searchQuery" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-success" type="submit">Search</button>
      </form>
    </div>
  </div>
</nav>
</body>
</html>