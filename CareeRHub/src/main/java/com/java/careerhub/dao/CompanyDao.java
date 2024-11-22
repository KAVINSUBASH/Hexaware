package com.java.careerhub.dao;

import java.sql.SQLException;
import java.util.List;

import com.java.careerhub.model.JobListing;

public interface CompanyDao {
	boolean postJob(int companyId, String jobTitle, String jobDescription, String jobLocation, double salary, String jobType) throws ClassNotFoundException,SQLException;
    List<JobListing> getJobs() throws ClassNotFoundException,SQLException;
}