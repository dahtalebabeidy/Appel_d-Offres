package com.projet_jee.appel_d_offres.model;

public class Submission {
	private String aoName;
	private String bidderName;
    private String phoneNumber;
    private String address;
    private double financialProposal;
    private String dateOfSubmission;
    private Reference references;
    
    
    public String getAoName() {
		return aoName;
	}
	public void setAoName(String aoName) {
		this.aoName = aoName;
	}
	public String getBidderName() {
		return bidderName;
	}
	public void setBidderName(String bidderName) {
		this.bidderName = bidderName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getFinancialProposal() {
		return financialProposal;
	}
	public void setFinancialProposal(double financialProposal) {
		this.financialProposal = financialProposal;
	}
	public String getDateOfSubmission() {
		return dateOfSubmission;
	}
	public void setDateOfSubmission(String dateOfSubmission) {
		this.dateOfSubmission = dateOfSubmission;
	}
	public Reference getReferences() {
		return references;
	}
	public void setReferences(Reference references) {
		this.references = references;
	}
    
    
}
