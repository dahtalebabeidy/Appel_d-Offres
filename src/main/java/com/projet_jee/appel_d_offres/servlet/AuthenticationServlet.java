package com.projet_jee.appel_d_offres.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.projet_jee.appel_d_offres.model.Administrator;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/authenticate")
public class AuthenticationServlet extends HttpServlet {
    private Administrator administrator;  // Assuming Administrator class is in the same package

    public void init() {
        // Initialize the administrator with default credentials
        administrator = new Administrator();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Set the content type to HTML
        response.setContentType("text/html");

        // Create PrintWriter to write HTML response
        PrintWriter out = response.getWriter();

        // HTML response for login page
        out.println("<html lang='en'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.println("<title>Log in d'administrateur</title>");
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
        out.println("<form action='" + request.getContextPath() + "/AuthenticationServlet' method='post'>");
        out.println("<h2>Log in</h2>");
        out.println("<div>");
        out.println("<label for='username'>nom d'utilisateur:</label>");
        out.println("<input type='text' id='username' name='username' required>");
        out.println("</div>");
        out.println("");
        out.println("<div>");
        out.println("<label for='password'>mot de passe:</label>");
        out.println("<input type='password' id='password' name='password' required>");
        out.println("</div>");
        out.println("");
        out.println("<div>");
        out.println("<input type='submit' value='Se Connecter'>");
        out.println("</div>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Retrieve user input from the form
        String enteredUsername = request.getParameter("username");
        String enteredPassword = request.getParameter("password");

        // Check if entered credentials match the administrator's credentials
        if (enteredUsername.equals(administrator.getUsername()) && enteredPassword.equals(administrator.getPassword())) {
            // Authentication successful
            response.getWriter().println("<html><body><h2>Authentication Successful!</h2></body></html>");
        } else {
            // Authentication failed
            response.getWriter().println("<html><body><h2>Authentication Failed. Try Again.</h2></body></html>");
        }
    }
}
