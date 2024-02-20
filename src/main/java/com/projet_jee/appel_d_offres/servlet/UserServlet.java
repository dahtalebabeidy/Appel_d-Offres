package com.projet_jee.appel_d_offres.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.projet_jee.appel_d_offres.model.AO;
import com.projet_jee.appel_d_offres.model.Submission;
import com.projet_jee.appel_d_offres.resource.AOResource;
import com.projet_jee.appel_d_offres.resource.SubmissionResource;
import com.projet_jee.appel_d_offres.resource.UserResource;

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
        out.println(".container {padding: 20px; display: flex;}");
        out.println(".ao-container, .submission-container { flex: 1; padding: 20px; }");
        out.println(".ao-list-container, .submission-list-container { margin-top: 20px; }");
        out.println(".ao-item, .submission-item { margin-bottom: 10px; padding: 10px; background-color: #ffffff; border: 1px solid #ddd; border-radius: 5px; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");

        out.println("<div class='dashboard-container'>");
        out.println("    <button class='dashboard-button'><a href='/appel-d-offres/SubmissionFormServlet'>Soumettre Un Offre</a></button>");
//        out.println("    <button class='dashboard-button'><a href='updateFinancialOfferForm'>Modifier Votre Offre Financier</a></button>");
        out.println("    <button class='dashboard-button'><a href='/appel-d-offres/UserLoginFormServlet'>Se Deconnecter</a></button>");
        out.println("</div>");
        
        out.println("<div class='container'>");
        out.println("    <div class='ao-container'>");
        out.println("        <h2>Liste des AO</h2>");
        out.println("        <div class='ao-list-container'>");

        List<AO> aoList = AOResource.getAllAOs();
        for (AO ao : aoList) {
            out.println("            <div class='ao-item'>");
            out.println("                <p><strong>Nom de l'AO:</strong> " + ao.getName() + "</p>");
            out.println("                <p><strong>Date limite:</strong> " + ao.getDeadline() + "</p>");
            out.println("                <p><strong>Projet:</strong> " + ao.getProject() + "</p>");
            out.println("                <p><strong>Client:</strong> " + ao.getClient() + "</p>");
            out.println("            </div>");
        }

        out.println("        </div>");
        out.println("    </div>");
        out.println("<div class=\"submission-container\">");
        out.println("	<h2>Liste des Soumissions</h2>");
        out.println("	<div class=\"submission-list-container\">");

        List<Submission> submissionList = SubmissionResource.getSubmissionsByUser(UserResource.u);
        for (Submission submission : submissionList) {
            out.println("	<div class=\"submission-item\">");
            out.println("		<p><strong>Le nom d'AO:</strong> " + submission.getAoName() + "</p>");
            out.println("		<p><strong>Utilisateur :</strong> " + submission.getBidderName() + "</p>");
            out.println("		<p><strong>Telephon:</strong> " + submission.getPhoneNumber() + "</p>");
            out.println("		<p><strong>Adresse :</strong> " + submission.getAddress() + "</p>");
            out.println("		<p><strong>Montant :</strong> " + submission.getFinancialProposal() + "</p>");
            out.println("		<p><strong>Date Soumission :</strong> " + submission.getDateOfSubmission() + "</p>");
            out.println("		<p><strong>Reference :</strong></p>");
            out.println("		<p><strong>Nom du Projet :</strong> " + submission.getReferences().getProjectReference() + "</p>");
            out.println("		<p><strong>Pour Quel Client :</strong> " + submission.getReferences().getClientReference() + "</p>");
            out.println("		<p><strong>Montant :</strong> " + submission.getReferences().getProjectAmount() + "</p>");
            out.println("		<p><strong>Date de Realisation :</strong> " + submission.getReferences().getProjectDate() + "</p>");
            out.println("		<button class='dashboard-button'><a href='ModifyFinancialOffer'>Modifier L'offre Financiere</a></button>");
            out.println("	</div>");
        }

        out.println("</div>");
        out.println("</div>");
        out.println("</div>");

        out.println("</body>");
        out.println("</html>");
    }

}
