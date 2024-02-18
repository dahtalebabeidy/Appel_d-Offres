package com.projet_jee.appel_d_offres.resource;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.io.IOException;

import com.projet_jee.appel_d_offres.model.Administrator;

@Path("/administrator")
public class AdministratorResource {
    private Administrator administrator;  // Assuming Administrator class is in the same package

    public AdministratorResource() {
        // Initialize the administrator with default credentials
        administrator = new Administrator();
    }

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_HTML)
    public String loginAdministrator(
            @FormParam("username") String username,
            @FormParam("password") String password,
            @Context HttpServletResponse servletResponse
    ) throws IOException {
        // Check if the administrator login is successful
        if (isValidAdministrator(username, password)) {
            // Redirect to AdminServlet after successful login
            servletResponse.sendRedirect("/appel-d-offres/AdminServlet");
            return "";
        } else {
            // Return HTML response for incorrect login
        	return "<html lang='en'>"
			       + "<head>"
			       + "<meta charset='UTF-8'>"
			       + "<meta name='viewport' content='width=device-width, initial-scale=1.0'>"
			       + "<title>Erreur</title>"
			       + "<style>"
			       + "body {"
			       + "    font-family: Arial, sans-serif;"
			       + "    background-color: #f4f4f4;"
			       + "    text-align: center;"
			       + "    margin: 20vh 0;"
			       + "}"
			       + ""
			       + ".container {"
			       + "    background: white;"
			       + "    border: 1px solid #dddddd;"
			       + "    padding: 25px;"
			       + "    border-radius: 10px;"
			       + "    box-shadow: 0 0 10px #00000f;"
			       + "    margin: 20px auto;"
			       + "    width: 30%;"
			       + "}"
			       + ""
			       + "h2, p {"
			       + "    color: #ff0000; /* Red color for the error message */"
			       + "}"
			       + "</style>"
			       + "</head>"
			       + "<body>"
			       + "<div class='container'>"
			       + "<h2>Erreur de connection</h2>"
			       + "<p>Nom ou mot de passe incorrect!</p>"
			       + "</div>"
			       + "<script>setTimeout(function(){ window.location.href='/appel-d-offres/AuthenticationServlet'; }, 1000);</script>"
			       + "</body>"
			       + "</html>";
        }
    }

    @POST
    @Path("/modifyPassword")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_HTML)
    public String modifyAdministratorPassword(
            @FormParam("oldPassword") String oldPassword,
            @FormParam("newPassword") String newPassword
    ) {
        // Check if the old password is correct
        if (administrator.getPassword().equals(oldPassword)) {
            // Update the administrator's password
            administrator.setPassword(newPassword);

            return "<html lang='en'>"
			       + "<head>"
			       + "<meta charset='UTF-8'>"
			       + "<meta name='viewport' content='width=device-width, initial-scale=1.0'>"
			       + "<title>Succès</title>"
			       + "<style>"
			       + "body {"
			       + "    font-family: Arial, sans-serif;"
			       + "    background-color: #f4f4f4;"
			       + "    text-align: center;"
			       + "    margin: 20vh 0;"
			       + "}"
			       + ""
			       + ".container {"
			       + "    background: white;"
			       + "    border: 1px solid #dddddd;"
			       + "    padding: 25px;"
			       + "    border-radius: 10px;"
			       + "    box-shadow: 0 0 10px #00000f;"
			       + "    margin: 20px auto;"
			       + "    width: 30%;"
			       + "}"
			       + ""
			       + "h2, p {"
			       + "    color: #198d19; /* Red color for the error message */"
			       + "}"
			       + "</style>"
			       + "</head>"
			       + "<body>"
			       + "<div class='container'>"
			       + "<h2>Succès</h2>"
			       + "<p>Mot de passe modifié avec succès!</p>"
			       + "</div>"
			       + "<script>setTimeout(function(){ window.location.href='/appel-d-offres/AuthenticationServlet'; }, 1000);</script>"
			       + "</body>"
			       + "</html>";
        } else {
            return "<html lang='en'>"
 			       + "<head>"
 			       + "<meta charset='UTF-8'>"
 			       + "<meta name='viewport' content='width=device-width, initial-scale=1.0'>"
 			       + "<title>Erreur</title>"
 			       + "<style>"
 			       + "body {"
 			       + "    font-family: Arial, sans-serif;"
 			       + "    background-color: #f4f4f4;"
 			       + "    text-align: center;"
 			       + "    margin: 20vh 0;"
 			       + "}"
 			       + ""
 			       + ".container {"
 			       + "    background: white;"
 			       + "    border: 1px solid #dddddd;"
 			       + "    padding: 25px;"
 			       + "    border-radius: 10px;"
 			       + "    box-shadow: 0 0 10px #00000f;"
 			       + "    margin: 20px auto;"
 			       + "    width: 30%;"
 			       + "}"
 			       + ""
 			       + "h2, p {"
 			       + "    color: #ff0000; /* Red color for the error message */"
 			       + "}"
 			       + "</style>"
 			       + "</head>"
 			       + "<body>"
 			       + "<div class='container'>"
 			       + "<h2>Erreur</h2>"
 			       + "<p>Ancien mot de passe incorrect.</p>"
 			       + "</div>"
 			       + "<script>setTimeout(function(){ window.location.href='/appel-d-offres/PasswordModificationServlet'; }, 1000);</script>"
 			       + "</body>"
 			       + "</html>";
        }
    }

    private boolean isValidAdministrator(String username, String password) {
        // Check if the administrator credentials are correct
        return administrator.getUsername().equals(username) && administrator.getPassword().equals(password);
    }
}

