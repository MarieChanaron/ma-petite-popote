package fr.mariech.tp.servlet;

import fr.mariech.tp.model.Recipe;
import fr.mariech.tp.service.RecipeService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "GetRecipeServlet", value = "/get-recipe")
public class GetRecipeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long recipeId = Long.parseLong(request.getParameter("id"));
        Recipe recipe = new RecipeService().fetchById(recipeId);
        request.setAttribute("recipe", recipe);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
