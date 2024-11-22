package com.java.careerhub.dao;

import java.sql.SQLException;

public interface ApplicantDao {
	boolean createProfile(String email, String firstName, String lastName, String phone, String Resume) throws SQLException, ClassNotFoundException;
    boolean applyForJob(int jobId,int applicantId, String coverLetter) throws SQLException, ClassNotFoundException;
}