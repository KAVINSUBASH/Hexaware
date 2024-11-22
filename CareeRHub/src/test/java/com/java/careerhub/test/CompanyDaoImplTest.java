package com.java.careerhub.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.java.careerhub.dao.CompanyDaoImpl;
import com.java.careerhub.model.JobListing;

public class CompanyDaoImplTest {

    CompanyDaoImpl companyDao;

    @Before
    public void setUp() {
        companyDao = new CompanyDaoImpl();
    }

    @Test
    public void testPostJob() throws SQLException, ClassNotFoundException {
        boolean result = companyDao.postJob(1, "Software Engineer", "Develop software", "New York", 90000.00, "Full-time");
        assertTrue(result);
    }

    @Test
    public void testGetJobs() throws SQLException, ClassNotFoundException {
        List<JobListing> jobs = companyDao.getJobs();
        assertFalse(jobs.isEmpty());
    }

    @Test
    public void testGetJobsNoJobs() throws SQLException, ClassNotFoundException {
        List<JobListing> jobs = companyDao.getJobs();
        assertFalse(jobs.isEmpty());
    }
}
