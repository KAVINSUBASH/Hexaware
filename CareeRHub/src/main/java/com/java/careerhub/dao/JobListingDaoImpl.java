package com.java.careerhub.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import com.java.careerhub.model.Applicant;
import com.java.careerhub.util.ConnectionHelper;

public class JobListingDaoImpl implements JobListingDao {

    Connection con;
    PreparedStatement pst;

    @Override
    public boolean apply(int applicantId, int jobId, String coverLetter)
            throws SQLException, ClassNotFoundException {
        String query = "insert into applications(applicantid, jobid, coverletter) values(?, ?, ?)";
        con = ConnectionHelper.getConnection();
        pst = con.prepareStatement(query);
        pst.setInt(1, applicantId);
        pst.setInt(2, jobId);
        pst.setString(3, coverLetter);
        int rowsAffected = pst.executeUpdate();
        return rowsAffected > 0;
    }

    @Override
    public List<Applicant> getApplicants(int jobId) throws SQLException, ClassNotFoundException {
        List<Applicant> applicants = new ArrayList<>();
        String query = "select a.applicantid, a.firstname, a.lastname, a.email, a.phone from applicants a " +
                       "join applications app on a.applicantid = app.applicantid where app.jobid = ?";
        con = ConnectionHelper.getConnection();
        pst = con.prepareStatement(query);
        pst.setInt(1, jobId);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            Applicant applicant = new Applicant();
            applicant.setApplicantId(rs.getInt("applicantId"));
            applicant.setFirstName(rs.getString("firstName"));
            applicant.setLastName(rs.getString("lastName"));
            applicant.setEmail(rs.getString("email"));
            applicant.setPhone(rs.getString("phone"));
            applicants.add(applicant);
        }
        return applicants;
    }
}
