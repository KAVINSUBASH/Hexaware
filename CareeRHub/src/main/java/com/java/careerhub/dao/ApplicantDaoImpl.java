package com.java.careerhub.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.java.careerhub.util.ConnectionHelper;

public class ApplicantDaoImpl implements ApplicantDao {

    Connection con;
    PreparedStatement pst;

    @Override
    public boolean createProfile(String email, String firstName, String lastName, String phone, String Resume)
            throws SQLException, ClassNotFoundException {
        String query = "insert into applicants(firstname, lastname, email, phone, resume) values (?, ?, ?, ?, ?)";
        con = ConnectionHelper.getConnection();
        pst = con.prepareStatement(query);
        pst.setString(1, firstName);
        pst.setString(2, lastName);
        pst.setString(3, email);
        pst.setString(4, phone);
        pst.setString(5, Resume);
        int rowsAffected = pst.executeUpdate();
        return rowsAffected > 0;
    }

    @Override
    public boolean applyForJob(int jobId, int applicantId, String coverLetter)
            throws SQLException, ClassNotFoundException {
        String query = "insert into applications(jobid, applicantid, coverletter) values (?, ?, ?)";
        con = ConnectionHelper.getConnection();
        pst = con.prepareStatement(query);
        pst.setInt(1, jobId);
        pst.setInt(2, applicantId);
        pst.setString(3, coverLetter);
        int rowsAffected = pst.executeUpdate();
        return rowsAffected > 0;
    }
}