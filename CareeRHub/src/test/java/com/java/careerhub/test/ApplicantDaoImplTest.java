package com.java.careerhub.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import com.java.careerhub.dao.ApplicantDaoImpl;

public class ApplicantDaoImplTest {

    private ApplicantDaoImpl app;

    @Before
    public void setUp() {
        app = new ApplicantDaoImpl();
    }

    @Test
    public void testCreateProfile() throws SQLException, ClassNotFoundException {
        boolean result = app.createProfile("kavin23@gmail.com", "kavin", "k r", "123", "resume");
        assertTrue(result);
    }

    @Test
    public void testApplyForJob() throws SQLException, ClassNotFoundException {
        boolean result = app.applyForJob(1, 1, "cover");
        assertTrue(result);
    }
}
