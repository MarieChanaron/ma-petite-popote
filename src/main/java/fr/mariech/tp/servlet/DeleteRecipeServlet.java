package fr.mariech.tp.servlet;

import fr.mariech.tp.service.RecipeService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "DeleteRecipeServlet", value = "/delete-recipe")
public class DeleteRecipeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long recipeId = Long.parseLong(request.getParameter("id"));
        new RecipeService().deleteRecipe(recipeId);
        response.sendRedirect("/administration");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
