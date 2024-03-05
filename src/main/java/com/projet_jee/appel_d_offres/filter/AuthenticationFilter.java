package com.projet_jee.appel_d_offres.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.projet_jee.appel_d_offres.model.Administrator;

@WebFilter("/webapi/login")
public class AuthenticationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    	Administrator admin;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String path = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());
        if (path.equals("/webapi/login")) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            if (isValidCredentials(username, password)) {
                chain.doFilter(request, response);
                httpResponse.sendRedirect("/appel-d-offres/AdminServlet");
            } else {
                httpResponse.sendRedirect("/appel-d-offres/AuthenticationServlet");
            }
        }
    }

    private boolean isValidCredentials(String username, String password) {
        return username.equals(Administrator.username) && password.equals(Administrator.password);
    }

    @Override
    public void destroy() {
    }
}
