package fr.mariech.tp.servlet;

import fr.mariech.tp.model.Recipe;
import fr.mariech.tp.service.RecipeService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "RecipeServlet", value = "/recipe")
public class RecipeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long recipeId = Long.parseLong(request.getParameter("id"));
        Recipe recipe = new RecipeService().fetchById(recipeId);
        System.out.println("RECIPE RECEIVED");
        System.out.println(recipe);
        request.setAttribute("recipe", recipe);
        request.getRequestDispatcher("/WEB-INF/recipe.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
