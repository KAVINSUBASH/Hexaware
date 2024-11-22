package com.java.careerhub.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.careerhub.model.JobListing;
import com.java.careerhub.util.ConnectionHelper;

public class CompanyDaoImpl implements CompanyDao {

    Connection con;
    PreparedStatement pst;

    @Override
    public boolean postJob(int companyId,String jobTitle, String jobDescription, String jobLocation, double salary, String jobType)
            throws SQLException, ClassNotFoundException {
        String query = "insert into jobs(jobtitle,CompanyId, jobdescription, joblocation, salary, jobtype) values (?, ?, ?, ?, ?, ?)";
        con = ConnectionHelper.getConnection();
        pst = con.prepareStatement(query);
        pst.setString(1, jobTitle);
        pst.setInt(2, companyId);
        pst.setString(3, jobDescription);
        pst.setString(4, jobLocation);
        pst.setDouble(5, salary);
        pst.setString(6, jobType);
        int rowsAffected = pst.executeUpdate();
        return rowsAffected > 0;
    }

    @Override
    public List<JobListing> getJobs() throws SQLException, ClassNotFoundException {
        List<JobListing> jobs = new ArrayList<>();
        String query = "select * from jobs";
        con = ConnectionHelper.getConnection();
        pst = con.prepareStatement(query);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            JobListing job = new JobListing();
            job.setJobId(rs.getInt("JobId"));
            job.setJobTitle(rs.getString("JobTitle"));
            job.setCompanyId(rs.getInt("CompanyId"));
            job.setJobDescription(rs.getString("JobDescription"));
            job.setJobLocation(rs.getString("JobLocation"));
            job.setSalary(rs.getDouble("Salary"));
            job.setJobType(rs.getString("JobType"));
            jobs.add(job);
        }
        return jobs;
    }
}
