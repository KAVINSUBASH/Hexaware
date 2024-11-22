package com.java.careerhub.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.java.careerhub.dao.JobListingDaoImpl;
import com.java.careerhub.model.Applicant;

public class JobListingDaoImplTest {

    JobListingDaoImpl jobListingDao;

    @Before
    public void setUp() {
        jobListingDao = new JobListingDaoImpl();
    }

    @Test
    public void testApply() throws SQLException, ClassNotFoundException {
        boolean result = jobListingDao.apply(1, 1, "Cover Letter Text");
        assertTrue(result);
    }

    @Test
    public void testGetApplicants() throws SQLException, ClassNotFoundException {
        List<Applicant> applicants = jobListingDao.getApplicants(4);
        assertFalse(applicants.isEmpty());
    }

    @Test
    public void testGetApplicantsNoApplicants() throws SQLException, ClassNotFoundException {
        List<Applicant> applicants = jobListingDao.getApplicants(11);
        assertTrue(applicants.isEmpty());
    }
}
