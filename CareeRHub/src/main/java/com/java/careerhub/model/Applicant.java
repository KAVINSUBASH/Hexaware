package com.java.careerhub.model;

public class Applicant {
	
	private int applicantId;
	private String firstName;
    private String lastName;
    private String email;
    private String phone;
    
    public int getApplicantId() {
		return applicantId;
	}
	public void setApplicantId(int applicantId) {
		this.applicantId = applicantId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Override
    public String toString() {
        return "Applicant{applicantId=" + applicantId + ", firstName='" + firstName + "', lastName='" + lastName +
               "', email='" + email + "', phone='" + phone + "'}";
    }
}
