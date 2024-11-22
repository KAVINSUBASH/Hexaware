package com.java.careerhub.dao;

import java.sql.SQLException;
import java.util.List;

import com.java.careerhub.model.Applicant;

public interface JobListingDao {
	boolean apply(int applicantId, int jobId, String coverLetter) throws SQLException,ClassNotFoundException;
	List<Applicant> getApplicants(int jobId) throws SQLException,ClassNotFoundException;
}
