package com.java.careerhub.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.java.careerhub.model.Company;

public class CompanyTest {

    private Company company;

    @Before
    public void setUp() {
        company = new Company("TechCorp", "New York");
        company.setCompanyId(1); 
    }

    @Test
    public void testGetterSetter() {
        company.setCompanyId(1);
        company.setCompanyName("TechCorp");
        company.setLocation("New York");

        assertEquals(1, company.getCompanyId());
        assertEquals("TechCorp", company.getCompanyName());
        assertEquals("New York", company.getLocation());
    }

    @Test
    public void testConstructor() {
        Company company = new Company("TechCorp", "New York");

        assertEquals("TechCorp", company.getCompanyName());
        assertEquals("New York", company.getLocation());
    }

    @Test
    public void testToString() {
        company.setCompanyId(1);
        company.setCompanyName("TechCorp");
        company.setLocation("New York");

        String expected = "Company [companyId=1, companyName=TechCorp, location=New York]";
        assertEquals(expected, company.toString());
    }
}
