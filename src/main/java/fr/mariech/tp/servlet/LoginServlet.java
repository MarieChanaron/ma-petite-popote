package fr.mariech.tp.servlet;

import fr.mariech.tp.service.UserService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        boolean userFound = new UserService().getUser(name, password);
        HttpSession session = request.getSession();
        session.setAttribute("loggedIn", userFound);
        response.sendRedirect("/index");
    }
}
