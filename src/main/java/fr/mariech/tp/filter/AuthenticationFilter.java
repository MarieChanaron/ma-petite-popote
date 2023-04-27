package fr.mariech.tp.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(urlPatterns = {"/administration/*", "/add-recipe", "/edit-recipe"})
public class AuthenticationFilter extends HttpFilter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        HttpSession session = request.getSession();
        if (session != null) {
            if (session.getAttribute("loggedIn").equals(true)) {
                // Continue la chaine des filtres/navigations
                chain.doFilter(req, res);
            } else {
                response.sendRedirect(request.getContextPath() + "/connexion");
            }
        }
    }
}
