package com.java.careerhub.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.java.careerhub.model.Applicant;

public class ApplicantTest {

    private Applicant applicant;

    @Before
    public void setUp() {
        applicant = new Applicant();
    }

    @Test
    public void testGetterSetter() {
        applicant.setApplicantId(1);
        applicant.setFirstName("Kavin");
        applicant.setLastName("Subash");
        applicant.setEmail("kavin@gmail.com");
        applicant.setPhone("6374424213");

        assertEquals(1, applicant.getApplicantId());
        assertEquals("Kavin", applicant.getFirstName());
        assertEquals("Subash", applicant.getLastName());
        assertEquals("kavin@gmail.com", applicant.getEmail());
        assertEquals("6374424213", applicant.getPhone());
    }

    @Test
    public void testToString() {
        applicant.setApplicantId(1);
        applicant.setFirstName("Kavin");
        applicant.setLastName("Subash");
        applicant.setEmail("kavin@gmail.com");
        applicant.setPhone("6374424213");

        String expected = "Applicant{applicantId=1, firstName='Kavin', lastName='Subash', email='kavin@gmail.com', phone='6374424213'}";
        assertEquals(expected, applicant.toString());
    }
}
