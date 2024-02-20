package com.projet_jee.appel_d_offres.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddAOFormServlet
 */
public class AddAOFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddAOFormServlet() {
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<html lang='en'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.println("<title>Ajouter Un AO</title>");
        out.println("<style>");
        out.println("body {");
        out.println("    font-family: Arial, sans-serif;");
        out.println("    background-color: #f4f4f4;");
        out.println("    text-align: center;");
        out.println("    margin: 20vh 0;");
        out.println("}");
        out.println("");
        out.println("form {");
        out.println("    background: white;");
        out.println("    border: 1px solid #dddddd;");
        out.println("    padding: 25px;");
        out.println("    border-radius: 10px;");
        out.println("    box-shadow: 0 0 10px #00000f;");
        out.println("    margin: 20px auto;");
        out.println("    width: 30%;");
        out.println("}");
        out.println("");
        out.println("form div {");
        out.println("    margin: 10px;");
        out.println("}");
        out.println("");
        out.println("form input, form button {");
        out.println("    border: 1px solid #ddd;");
        out.println("    border-radius: 5px;");
        out.println("    padding: 10px;");
        out.println("    font-size: 1.2rem;");
        out.println("    font-family: 'Nunito';");
        out.println("    width: 100%;");
        out.println("}");
        out.println("");
        out.println("form label {");
        out.println("    display: inherit;");
        out.println("    font-size: .9rem;");
        out.println("    padding-bottom: 3px;");
        out.println("    color: #9d9d9d;");
        out.println("}");
        out.println("");
        out.println("form input[type='submit'], form button {");
        out.println("    border: 1px solid #ddd;");
        out.println("    padding: 10px 25px;");
        out.println("    font-size: 1.1rem;");
        out.println("    margin: 10px 0;");
        out.println("    border-radius: 5px;");
        out.println("    cursor: pointer;");
        out.println("}");
        out.println("");
        out.println("form input[type='submit']:hover, form button:hover {");
        out.println("    background-color: #00000f;");
        out.println("    color: white;");
        out.println("}");
        out.println("");
        out.println("form button:hover a {");
        out.println("    color: white;");
        out.println("}");
        out.println("");
        out.println("form button {");
        out.println("    margin: 0px;");
        out.println("}");
        out.println("");
        out.println("form a {");
        out.println("    text-decoration: none;");
        out.println("    color: buttontext;");
        out.println("}");
        out.println("");
        out.println(".error-message {");
        out.println("    color: red;");
        out.println("}");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<form action='" + request.getContextPath() + "/webapi/ao/add' method='post'>");
        out.println("<h2>Ajouter Un AO</h2>");
        out.println("<div>");
        out.println("    <label for='name'>Nom de l'AO:</label>");
        out.println("    <input type='text' id='name' name='name' required><br>");
        out.println("</div>");
        out.println("");
        out.println("<div>");
        out.println("    <label for='deadline'>Date limite:</label>");
        out.println("    <input type='date' id='deadline' name='deadline' required><br>");
        out.println("</div>");
        out.println("");
        out.println("<div>");
        out.println("    <label for='project'>Projet:</label>");
        out.println("    <input type='text' id='project' name='project' required><br>");
        out.println("</div>");
        out.println("");
        out.println("<div>");
        out.println("    <label for='client'>Client:</label>");
        out.println("    <input type='text' id='client' name='client' required><br>");
        out.println("</div>");
        out.println("");
        out.println("<div>");
        out.println("<input type='submit' value='Ajouter AO'>");
        out.println("</div>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
	}

}
