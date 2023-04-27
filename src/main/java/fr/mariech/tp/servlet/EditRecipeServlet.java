package fr.mariech.tp.servlet;

import fr.mariech.tp.model.Recipe;
import fr.mariech.tp.service.RecipeService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "EditRecipeServlet", value = "/edit-recipe")
public class EditRecipeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("id", request.getParameter("id"));
        request.getRequestDispatcher("/WEB-INF/edit-recipe.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("name");
        String image = request.getParameter("image");
        long categoryId = Long.parseLong(request.getParameter("category"));
        String text = request.getParameter("content");
        new RecipeService().updateRecipe(id, name, text, image, categoryId);
        response.sendRedirect("/administration");
    }
}
