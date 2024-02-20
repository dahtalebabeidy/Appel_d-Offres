package com.projet_jee.appel_d_offres.resource;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.io.IOException;
import java.net.URI;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.projet_jee.appel_d_offres.model.AO;

@Path("/ao")
public class AOResource {
	private static List<AO> aoList = new ArrayList<>();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public static List<AO> getAllAOs() {
        return aoList;
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String addAO(
            @FormParam("name") String name,
            @FormParam("deadline") String deadline,
            @FormParam("project") String project,
            @FormParam("client") String client,
            @Context HttpServletResponse servletResponse) throws IOException {
    	
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate deadlineDate = LocalDate.parse(deadline, formatter);

        if (deadlineDate.isBefore(LocalDate.now())) {
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
 			       + "<p>La date limite est inccorect!</p>"
 			       + "</div>"
 			       + "<script>setTimeout(function(){ window.location.href='/appel-d-offres/AddAOFormServlet'; }, 1000);</script>"
 			       + "</body>"
 			       + "</html>";
        }
        
        AO ao = new AO();
        ao.setName(name);
        ao.setDeadline(deadline);
        ao.setProject(project);
        ao.setClient(client);
        
        if (aoList == null) {
            aoList = new ArrayList<>();
        }

        aoList.add(ao);

        servletResponse.sendRedirect("/appel-d-offres/AdminServlet");
        return "";
    }
    
    @DELETE
    @Path("/delete")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response deleteAO(String aoName,
                              @Context HttpServletResponse servletResponse) throws IOException {
        AO aoToDelete = getAOByName(aoName);

        if (aoToDelete != null) {
            aoList.remove(aoToDelete);
            // Redirect to AdminServlet using sendRedirect
            servletResponse.sendRedirect("/appel-d-offres/AdminServlet");
            return Response.ok().build();  // You can return any appropriate response here
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("AO not found").build();
        }
    }
    
    @POST
    @Path("/extend")
    @Produces(MediaType.TEXT_HTML)
    public Response extendDeadline(@FormParam("aoName") String aoName, @FormParam("newDeadline") String newDeadline) {
        // Retrieve the AO object based on the AO name
        AO aoToExtend = getAOByName(aoName);

        if (aoToExtend != null && isValidDeadlineExtension(aoToExtend.getDeadline(), newDeadline)) {
            // Perform the deadline extension (you'll need to implement this logic)
            // For example, assign the new deadline to the AO
            aoToExtend.setDeadline(newDeadline);

            // Update the AO object in your data source (e.g., list)
            updateAO(aoToExtend);

            // Redirect to AdminServlet
            return Response.status(Response.Status.SEE_OTHER)
                    .header("Location", "/appel-d-offres/AdminServlet")
                    .entity("")
                    .build();
        } else {
            // AO doesn't exist, display a message
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(
                			   "<html lang='en'>"
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
              			       + "<p>Le nom d'AO ou la date est inccorect!</p>"
              			       + "</div>"
              			       + "<script>setTimeout(function(){ window.location.href='/appel-d-offres/ExtendAOForm'; }, 1000);</script>"
              			       + "</body>"
              			       + "</html>"
                    		)
                    .build();
        }
    }
    
    private AO getAOByName(String aoName) {
        for (AO ao : aoList) {
            if (ao.getName().equals(aoName)) {
                return ao;  // Found the AO with the specified name
            }
        }
        return null;  // AO with the specified name not found
    }

    private void updateAO(AO updatedAO) {
        // Implement logic to update AO in your data source (e.g., list)
        for (int i = 0; i < aoList.size(); i++) {
            if (aoList.get(i).getName().equals(updatedAO.getName())) {
                aoList.set(i, updatedAO);
                break;
            }
        }
    }

    private boolean isValidDeadlineExtension(String oldDeadline, String newDeadline) {
        // Implement logic to check if the new deadline is after the old deadline
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate oldDate = LocalDate.parse(oldDeadline, formatter);
        LocalDate newDate = LocalDate.parse(newDeadline, formatter);

        return newDate.isAfter(oldDate);
    }


}
