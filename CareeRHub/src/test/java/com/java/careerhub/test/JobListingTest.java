package com.java.careerhub.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.java.careerhub.model.JobListing;

public class JobListingTest {

    private JobListing jobListing;

    @Before
    public void setUp() {
        jobListing = new JobListing(1, "Software Engineer", "Develop software", "New York", 90000.00, "Full-time");
        jobListing.setJobId(1);  // Set the jobId explicitly for testing
    }

    @Test
    public void testGetterSetter() {
        jobListing.setJobId(1);
        jobListing.setCompanyId(1);
        jobListing.setJobTitle("Software Engineer");
        jobListing.setJobDescription("Develop software");
        jobListing.setJobLocation("New York");
        jobListing.setSalary(90000.00);
        jobListing.setJobType("Full-time");

        assertEquals(1, jobListing.getJobId());
        assertEquals(1, jobListing.getCompanyId());
        assertEquals("Software Engineer", jobListing.getJobTitle());
        assertEquals("Develop software", jobListing.getJobDescription());
        assertEquals("New York", jobListing.getJobLocation());
        assertEquals(90000.00, jobListing.getSalary(), 0.0);
        assertEquals("Full-time", jobListing.getJobType());
    }

    @Test
    public void testConstructor() {
        JobListing jobListing = new JobListing(1, "Software Engineer", "Develop software", "New York", 90000.00, "Full-time");

        assertEquals(1, jobListing.getCompanyId());
        assertEquals("Software Engineer", jobListing.getJobTitle());
        assertEquals("Develop software", jobListing.getJobDescription());
        assertEquals("New York", jobListing.getJobLocation());
        assertEquals(90000.00, jobListing.getSalary(), 0.0);
        assertEquals("Full-time", jobListing.getJobType());
    }

    @Test
    public void testToString() {
        jobListing.setJobId(1);
        jobListing.setCompanyId(1);
        jobListing.setJobTitle("Software Engineer");
        jobListing.setJobDescription("Develop software");
        jobListing.setJobLocation("New York");
        jobListing.setSalary(90000.00);
        jobListing.setJobType("Full-time");

        String expected = "JobListing{jobId=1, companyId=1, jobTitle='Software Engineer', jobDescription='Develop software', jobLocation='New York', salary=90000.0, jobType='Full-time'}";
        assertEquals(expected, jobListing.toString());
    }
}
