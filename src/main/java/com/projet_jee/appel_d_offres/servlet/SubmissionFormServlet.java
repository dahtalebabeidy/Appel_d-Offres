package com.projet_jee.appel_d_offres.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SubmissionFormServlet
 */
public class SubmissionFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SubmissionFormServlet() {
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
        out.println("<title>Soumettre une Offre</title>");
        out.println("<style>");
        out.println("body {");
        out.println("font-family: Arial, sans-serif;");
        out.println("background-color: #f4f4f4;");
        out.println("text-align: center;");
        out.println("margin: 20vh 0;");
        out.println("}");

        out.println("form {");
        out.println("background: white;");
        out.println("border: 1px solid #dddddd;");
        out.println("padding: 25px;");
        out.println("border-radius: 10px;");
        out.println("box-shadow: 0 0 10px #00000f;");
        out.println("margin: 20px auto;");
        out.println("width: 30%;");
        out.println("}");

        out.println("form div {");
        out.println("margin: 10px;");
        out.println("}");

        out.println("form input, form button {");
        out.println("border: 1px solid #ddd;");
        out.println("border-radius: 5px;");
        out.println("padding: 10px;");
        out.println("font-size: 1.2rem;");
        out.println("font-family: 'Nunito';");
        out.println("width: 100%;");
        out.println("}");

        out.println("form label {");
        out.println("display: inherit;");
        out.println("font-size: .9rem;");
        out.println("padding-bottom: 3px;");
        out.println("color: #9d9d9d;");
        out.println("}");

        out.println("form input[type=\"submit\"], form button {");
        out.println("border: 1px solid #ddd;");
        out.println("padding: 10px 25px;");
        out.println("font-size: 1.1rem;");
        out.println("margin: 10px 0;");
        out.println("border-radius: 5px;");
        out.println("cursor: pointer;");
        out.println("}");

        out.println("form input[type=\"submit\"]:hover, form button:hover {");
        out.println("background-color: #00000f;");
        out.println("color: white;");
        out.println("}");

        out.println(".error-message {");
        out.println("color: red;");
        out.println("}");
        out.println("</style>");
        out.println("</head>");

        out.println("<body>");
        out.println("<form action='" + request.getContextPath() + "/webapi/submission/add' method=\"post\">");
        out.println("<h2>Soumettre une Offre</h2>");

        out.println("<div>");
        out.println("<label for=\"aoName\">Le nom d'AO:</label>");
        out.println("<input type=\"text\" name=\"aoName\" required>");
        out.println("</div>");

        out.println("<div>");
        out.println("<label for=\"bidderName\">Nom d'utilisateur:</label>");
        out.println("<input type=\"text\" name=\"bidderName\" required>");
        out.println("</div>");

        out.println("<div>");
        out.println("<label for=\"phoneNumber\">Telephone:</label>");
        out.println("<input type=\"number\" name=\"phoneNumber\" required>");
        out.println("</div>");

        out.println("<div>");
        out.println("<label for=\"address\">Adresse:</label>");
        out.println("<input type=\"text\" name=\"address\" required>");
        out.println("</div>");

        out.println("<div>");
        out.println("<label for=\"financialProposal\">Montant:</label>");
        out.println("<input type=\"number\" name=\"financialProposal\" required>");
        out.println("</div>");

        out.println("<div>");
        out.println("<label for=\"dateOfSubmission\">Date de soumission:</label>");
        out.println("<input type=\"date\" name=\"dateOfSubmission\" required>");
        out.println("</div>");

        out.println("<p>Références:</p>");

        out.println("<div>");
        out.println("<label for=\"projectReference\">Nom du projet:</label>");
        out.println("<input type=\"text\" name=\"projectReference\" required>");
        out.println("</div>");

        out.println("<div>");
        out.println("<label for=\"clientReference\">Pour quel client :</label>");
        out.println("<input type=\"text\" name=\"clientReference\" required>");
        out.println("</div>");

        out.println("<div>");
        out.println("<label for=\"projectAmount\">Montant (référence) :</label>");
        out.println("<input type=\"number\" name=\"projectAmount\" required>");
        out.println("</div>");

        out.println("<div>");
        out.println("<label for=\"projectDate\">Date de réalisation :</label>");
        out.println("<input type=\"date\" name=\"projectDate\" required>");
        out.println("</div>");

        out.println("<div>");
        out.println("<input type=\"submit\" value=\"Soumettre\">");
        out.println("</div>");

        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
	}

}
