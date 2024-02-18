package com.projet_jee.appel_d_offres.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UserServlet() {
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

        // Create PrintWriter to write HTML response
        PrintWriter out = response.getWriter();

        // Write the HTML content dynamically
        out.println("<html lang='en'>");
        out.println("<head>");
        out.println("<style>");
        out.println("body {");
        out.println("    font-family: Arial, sans-serif;");
        out.println("    background-color: #f4f4f4;");
        out.println("    margin: 0;");
        out.println("    padding: 0;");
        out.println("}");
        out.println(".dashboard-container {");
        out.println("    display: flex;");
        out.println("    justify-content: space-between;");
        out.println("    padding: 20px;");
        out.println("}");
        out.println(".dashboard-button {");
        out.println("    padding: 10px;");
        out.println("    background-color: #00000f;");
        out.println("    color: white;");
        out.println("    text-decoration: none;");
        out.println("    border: none;");
        out.println("    border-radius: 5px;");
        out.println("    font-size: 16px;");
        out.println("    cursor: pointer;");
        out.println("    transition: background-color 0.3s ease;");
        out.println("}");
        out.println(".dashboard-button:hover {");
        out.println("    background-color: #fff;");
        out.println("    color: #00000f;");
        out.println("}");
        out.println(".dashboard-button:hover a {");
        out.println("    color: #00000f;");
        out.println("}");
        out.println("a {");
        out.println("    color: white;");
        out.println("    text-decoration: none;");
        out.println("}");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");

        // Dynamic content for the dashboard buttons
        out.println("<div class='dashboard-container'>");
        out.println("    <button class='dashboard-button'><a href='/appel-d-offres/s'>Soumettre Un Offre</a></button>");
//        out.println("    <button class='dashboard-button'><a href='updateFinancialOfferForm'>Modifier Votre Offre Financier</a></button>");
        out.println("    <button class='dashboard-button'><a href='/appel-d-offres/UserLoginFormServlet'>Se Deconnecter</a></button>");
        out.println("</div>");

        out.println("</body>");
        out.println("</html>");
    }

}
