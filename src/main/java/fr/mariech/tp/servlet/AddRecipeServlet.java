package fr.mariech.tp.servlet;

import fr.mariech.tp.model.Category;
import fr.mariech.tp.service.RecipeService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AddRecipeServlet", value = "/administration/add-recipe")
public class AddRecipeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/add-recipe.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String image = request.getParameter("image");
        long categoryId = Long.parseLong(request.getParameter("category"));
        String text = request.getParameter("content");
        new RecipeService().insertRecipe(name, text, image, categoryId);
        response.sendRedirect("/administration");
    }
}
