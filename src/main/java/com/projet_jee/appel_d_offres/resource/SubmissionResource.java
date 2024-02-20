package com.projet_jee.appel_d_offres.resource;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import com.projet_jee.appel_d_offres.model.AO;
import com.projet_jee.appel_d_offres.model.Reference;
import com.projet_jee.appel_d_offres.model.Submission;
import com.projet_jee.appel_d_offres.model.User;

@Path("/submission")
public class SubmissionResource {

    private static List<Submission> submissionList = new ArrayList<>(); // Assume you have a list of Submission objects, replace with your actual data structure
    private static List<AO> aoList = AOResource.getAllAOs(); // Assume you have a list of AO objects, replace with your actual data structure
    private static List<User> userList = UserResource.getAllUsers(); // Assume you have a list of User objects, replace with your actual data structure

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public static List<Submission> getAllSubmissions() {
        return submissionList;
    }
    
    @POST
    @Path("/add")
    @Produces(MediaType.TEXT_HTML)
    public Response addSubmission(
            @FormParam("aoName") String aoName,
            @FormParam("bidderName") String bidderName,
            @FormParam("phoneNumber") String phoneNumber,
            @FormParam("address") String address,
            @FormParam("financialProposal") double financialProposal,
            @FormParam("dateOfSubmission") String dateOfSubmission,
            @FormParam("projectReference") String projectReference,
            @FormParam("clientReference") String clientReference,
            @FormParam("projectAmount") double projectAmount,
            @FormParam("projectDate") String projectDate) {

        // Check if AO with the specified name already exists
        if (isAONameExists(aoName) && isBidderNameExists(bidderName)) {

	        // Create a new Submission object
	        Submission submission = new Submission();
	        submission.setAoName(aoName);
	        submission.setBidderName(bidderName);
	        submission.setPhoneNumber(phoneNumber);
	        submission.setAddress(address);
	        submission.setFinancialProposal(financialProposal);
	        submission.setDateOfSubmission(dateOfSubmission);
	
	        // Create a new Reference object
	        Reference reference = new Reference();
	        reference.setProjectReference(projectReference);
	        reference.setClientReference(clientReference);
	        reference.setProjectAmount(projectAmount);
	        reference.setProjectDate(projectDate);
	
	        // Add the Reference to the Submission
	        submission.setReferences(reference);
	
	        // Add the Submission to the list
	        submissionList.add(submission);
	
	        // Return success message
	        return Response.status(Response.Status.SEE_OTHER)
                    .header("Location", "/appel-d-offres/UserServlet")
                    .entity("")
                    .build();
        } else {
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
              			       + "<p>Le nom d'AO ou le nom de l'utilisateur est inccorect!</p>"
              			       + "</div>"
              			       + "<script>setTimeout(function(){ window.location.href='/appel-d-offres/SubmissionFormServlet'; }, 1000);</script>"
              			       + "</body>"
              			       + "</html>"
                    		)
                    .build();
        }
    }

    @Path("/modifyFinancialOffer")
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response modifyFinancialOffer(
            @FormParam("aoname") String aoname,
            @FormParam("username") String username,
            @FormParam("newFinancialOffer") double newFinancialOffer
    ) {
            for (Submission submission : submissionList) {
                if (submission.getAoName().equals(aoname) && submission.getBidderName().equals(username)) {
                    submission.setFinancialProposal(newFinancialOffer);
                    // You may want to update your data source if needed
                    // (e.g., if you are using a database)
                    // updateSubmission(submission);
                    
                    // Redirect to userservlet
                    return Response.status(Response.Status.SEE_OTHER)
                            .header("Location", "/appel-d-offres/UserServlet")
                            .entity("")
                            .build();
                }
            }
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
              			       + "<p>Le nom d'AO ou L'utilisateur est inccorect!</p>"
              			       + "</div>"
              			       + "<script>setTimeout(function(){ window.location.href='/appel-d-offres/ModifyFinancialOffer'; }, 1000);</script>"
              			       + "</body>"
              			       + "</html>"
                    		)
                    .build(); 
    }

    private boolean isAONameExists(String aoName) {
        // Check if AO with the specified name exists in the AO list
        for (AO ao : aoList) {
            if (ao.getName().equals(aoName)) {
                return true;
            }
        }
        return false;
    }

    private boolean isBidderNameExists(String bidderName) {
        // Check if BidderName already exists in the list of users
        for (User user : userList) {
            if (user.getUsername().equals(bidderName)) {
                return true;
            }
        }
        return false;
    }

    public static List<Submission> getSubmissionsByUser(String user) {
        List<Submission> userSubmissions = new ArrayList<>();
        for (Submission submission : submissionList) {
            if (submission.getBidderName().equals(user)) {
                userSubmissions.add(submission);
            }
        }
        return userSubmissions;
    }
}
