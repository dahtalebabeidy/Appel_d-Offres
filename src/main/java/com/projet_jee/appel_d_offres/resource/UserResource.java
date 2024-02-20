package com.projet_jee.appel_d_offres.resource;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.projet_jee.appel_d_offres.model.Submission;
import com.projet_jee.appel_d_offres.model.User;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/users")
public class UserResource {
	private static List<User> userList = new ArrayList<>();
	public static String u = "";

    static {
        // Assume there's a predefined user for demonstration purposes
        userList.add(new User("user1", "password123"));
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public static List<User> getAllUsers() {
        return userList;
    }

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_HTML)
    public String loginUser(
            @FormParam("username") String username,
            @FormParam("password") String password,
            @Context HttpServletResponse servletResponse
    ) throws IOException {
        // Check if the user exists and the password is correct
    	if (isValidUser(username, password)) {
            // Redirect to userservlet after successful login
    		u = username;
            servletResponse.sendRedirect("/appel-d-offres/UserServlet");
            return ""; // Return an empty string for successful redirect
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
			       + "<p>Nom d'utilisateur ou mot de passe incorrect!</p>"
			       + "</div>"
			       + "<script>setTimeout(function(){ window.location.href='/appel-d-offres/UserLoginFormServlet'; }, 1000);</script>"
			       + "</body>"
			       + "</html>";
        }
    }
    
    @POST
    @Path("/signup")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_HTML)
    public String signUpUser(
            @FormParam("username") String username,
            @FormParam("password") String password
    ) {
        // Check if the username is available
        if (isUsernameAvailable(username)) {
            // Create a new user and add it to the user list
            User newUser = new User(username, password);
            userList.add(newUser);

            // Return HTML response for successful signup
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
			       + "<p>Utilisateur inscrit avec succès!</p>"
			       + "</div>"
			       + "<script>setTimeout(function(){ window.location.href='/appel-d-offres/UserLoginFormServlet'; }, 1000);</script>"
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
			       + "<h2>Erreur d'inscription</h2>"
			       + "<p>Le nom d'utilisateur est déjà pris. Veuillez choisir un autre nom d'utilisateur!</p>"
			       + "</div>"
			       + "<script>setTimeout(function(){ window.location.href='/appel-d-offres/UserSignUpFormServlet'; }, 1000);</script>"
			       + "</body>"
			       + "</html>";
        }
    }

    private boolean isUsernameAvailable(String username) {
        // Check if the username is not already in use
        return userList.stream().noneMatch(user -> user.getUsername().equals(username));
    }
    
    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_HTML)
    public String addUser(@FormParam("username") String username, @FormParam("password") String password) {
        User newUser = new User(username, password);

        userList.add(newUser);

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
		       + "<p>Utilisateur ajouté avec succès!</p>"
		       + "</div>"
		       + "<script>setTimeout(function(){ window.location.href='/appel-d-offres/AddUserFormServlet'; }, 1000);</script>"
		       + "</body>"
		       + "</html>";
    }
    
    private boolean isValidUser(String username, String password) {
        for (User user : userList) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
    
}
