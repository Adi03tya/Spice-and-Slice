<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
    
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
	<jsp:include page="navbar.jsp" />
	<div class="container mt-5 border border-1.5 shadow rounded mb-3" >
    <form action="setRecipe" method="post">
    <div class="container p-3">
    <div style="max-width: fit-content;
  margin-left: auto;
  margin-right: auto;">
        <h2>Add a Recipe</h2>
      </div>  
        <!-- Recipe Name Input -->
        Recipe Name: <input type="text" name="recipe_name" class="form-control mb-2"><br>
        
        <!-- Recipe Description Input -->
       <!--  Recipe description: <input type="text" name="recipe_description" class="form-control mb-2"><br> -->
       Recipe Description:
        <div class="form-floating mb-4">
  <textarea class="form-control " name="recipe_description"></textarea>
</div>
        <!-- Ingredient Input Section -->
   
            Add Ingredients:            
            <!-- Container for ingredient inputs -->
            <div id="ingredient-container" class="mb-3 mt-2">
                <div class="ingredient-input mb-2">
                    <input type="text" name="ingredients[]" class="form-control" placeholder="Enter ingredient">
                </div>
            
            <!-- Add Ingredient Button -->

        </div>
       
         <button id="add-ingredient" type="button" class="btn btn-outline-primary btn-sm " >Add Ingredient</button>
         
        <!-- Submit Button -->
        <!-- <input type="submit" value="Add Recipe" class="btn btn-success mt-3"> -->
        <div class="d-grid gap-2 col-2 mx-auto mb-2">
		  <button class="btn btn-success" type="submit">Add Recipe</button>
  
</div>
        
    </form>
	</div>
    <script>
        // Add a new ingredient input field on button click
        document.getElementById("add-ingredient").addEventListener("click", function(event) {
            event.preventDefault(); // Prevents form submission

            // Create a new div for the ingredient input
            var newIngredientDiv = document.createElement("div");
            newIngredientDiv.classList.add("ingredient-input", "mb-2");

            // Create the new input field
            var newIngredientInput = document.createElement("input");
            newIngredientInput.type = "text";
            newIngredientInput.name = "ingredients[]";  // Use array notation for server processing
            newIngredientInput.classList.add("form-control");
            newIngredientInput.placeholder = "Enter ingredient";

            // Append the new input to the div, and the div to the container
            newIngredientDiv.appendChild(newIngredientInput);
            document.getElementById("ingredient-container").appendChild(newIngredientDiv);
        });
    </script>
</body>
</html>
 