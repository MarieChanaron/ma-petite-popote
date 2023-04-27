package fr.mariech.tp.servlet;

import fr.mariech.tp.model.Recipe;
import fr.mariech.tp.service.RecipeService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "RandomServlet", value = "/random")
public class RandomServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Recipe> recipes = new RecipeService().fetchRecipes();
        long nbRecipes = recipes.size();
        double rand = Math.floor(Math.random() * nbRecipes);
        int randInt = (int) rand;
        long randomRecipeId = recipes.get(randInt).getId();
        response.sendRedirect("/recipe?id=" + randomRecipeId);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
