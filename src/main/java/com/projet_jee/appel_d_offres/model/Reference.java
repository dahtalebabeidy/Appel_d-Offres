package com.projet_jee.appel_d_offres.model;

public class Reference {
	private String projectReference;
    private String clientReference;
    private double projectAmount;
    private String projectDate;
    
    
	public String getProjectReference() {
		return projectReference;
	}
	public void setProjectReference(String projectReference) {
		this.projectReference = projectReference;
	}
	public String getClientReference() {
		return clientReference;
	}
	public void setClientReference(String clientReference) {
		this.clientReference = clientReference;
	}
	public double getProjectAmount() {
		return projectAmount;
	}
	public void setProjectAmount(double projectAmount) {
		this.projectAmount = projectAmount;
	}
	public String getProjectDate() {
		return projectDate;
	}
	public void setProjectDate(String projectDate) {
		this.projectDate = projectDate;
	}
    
    
}
