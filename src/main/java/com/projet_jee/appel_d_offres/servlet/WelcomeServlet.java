package com.projet_jee.appel_d_offres.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\" />");
        out.println("<title>Bienvenu</title>");
        out.println("<style>");
        out.println("body {");
        out.println("font-family: Arial, sans-serif;");
        out.println("background-color: #f4f4f4;");
        out.println("text-align: center;");
        out.println("margin: 20vh 0;");
        out.println("}");

        out.println(".parent {");
        out.println("background: white;");
        out.println("border: 1px solid #dddddd;");
        out.println("padding: 25px;");
        out.println("border-radius: 10px;");
        out.println("box-shadow: 0 0 10px #00000f;");
        out.println("margin: 20px auto;");
        out.println("width: 30%;");
        out.println("}");

        out.println(".parent div {");
        out.println("margin: 10px;");
        out.println("}");

        out.println(".parent input, div button {");
        out.println("border: 1px solid #ddd;");
        out.println("border-radius: 5px;");
        out.println("padding: 10px;");
        out.println("font-size: 1.2rem;");
        out.println("font-family: 'Nunito';");
        out.println("width: 100%;");
        out.println("}");

        out.println("div button:hover {");
        out.println("background-color: #00000f;");
        out.println("color: white;");
        out.println("}");

        out.println("div button:hover a {");
        out.println("color: white;");
        out.println("}");

        out.println("a {");
        out.println("text-decoration: none;");
        out.println("color: buttontext; ");
        out.println("}");

        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class=\"parent\">");
        out.println("<div>Bienvenu Conectez en tant que un :</div>");
        out.println("<div><button><a href=\"/appel-d-offres/AuthenticationServlet\">Administrateur</a></button></div>");
        out.println("<p>Ou</p>");
        out.println("<div><button><a href=\"/appel-d-offres/UserLoginFormServlet\">Utilisateur</a></button></div>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
}
