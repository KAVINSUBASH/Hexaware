package com.java.careerhub.main;

import com.java.careerhub.dao.*;
import com.java.careerhub.model.*;
import com.java.careerhub.exceptions.InvalidEmailException;
import com.java.careerhub.exceptions.NegativeSalaryException;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class CareerHubMain {

    static Scanner sc = new Scanner(System.in);
    static CompanyDao companyDAO = new CompanyDaoImpl();
    static ApplicantDao applicantDAO = new ApplicantDaoImpl();
    static JobListingDao jobListingDAO = new JobListingDaoImpl();

    public static void getJobs() throws SQLException, ClassNotFoundException {
        List<JobListing> jobList = companyDAO.getJobs();
        if (jobList.isEmpty()) {
            System.out.println("No jobs available.");
        } else {
            for (JobListing job : jobList) {
                System.out.println(job);
            }
        }
    }

    public static void postJob() throws SQLException, ClassNotFoundException, NegativeSalaryException {
        System.out.println("Enter Job Details:");
        System.out.print("ComapnyId: ");
        int companyId=sc.nextInt();
        sc.nextLine();
        System.out.print("Job Title: ");
        String jobTitle = sc.nextLine();
        System.out.print("Job Description: ");
        String jobDescription = sc.nextLine();
        System.out.print("Job Location: ");
        String jobLocation = sc.nextLine();
        System.out.print("Salary: ");
        double salary = sc.nextDouble();
        sc.nextLine();
        System.out.print("Job Type (Full-time/Part-time/Contract): ");
        String jobType = sc.nextLine();

        boolean success = companyDAO.postJob(companyId,jobTitle, jobDescription, jobLocation, salary, jobType);
        if (success) {
            System.out.println("Job posted successfully!");
        } else {
            System.out.println("Failed to post the job.");
        }
    }

    public static void createProfile() throws SQLException, ClassNotFoundException, InvalidEmailException {
        System.out.println("Enter Applicant Details:");
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("First Name: ");
        String firstName = sc.nextLine();
        System.out.print("Last Name: ");
        String lastName = sc.nextLine();
        System.out.print("Phone: ");
        String phone = sc.nextLine();
        System.out.print("Resume: ");
        String Resume=sc.nextLine();

        boolean success = applicantDAO.createProfile(email, firstName, lastName, phone, Resume);
        if (success) {
            System.out.println("Applicant profile created successfully!");
        } else {
            System.out.println("Failed to create the applicant profile.");
        }
    }

    public static void applyForJob() throws SQLException, ClassNotFoundException {
        System.out.print("Enter Applicant ID: ");
        int applicantId = sc.nextInt();
        System.out.print("Enter Job ID: ");
        int jobId = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Cover Letter: ");
        String coverLetter = sc.nextLine();

        boolean success = jobListingDAO.apply(applicantId, jobId, coverLetter);
        if (success) {
            System.out.println("Application submitted successfully!");
        } else {
            System.out.println("Failed to submit application.");
        }
    }

    public static void getApplicants() throws SQLException, ClassNotFoundException {
        System.out.print("Enter Job ID to view applicants: ");
        int jobId = sc.nextInt();
        sc.nextLine();

        List<Applicant> applicants = jobListingDAO.getApplicants(jobId);
        if (applicants.isEmpty()) {
            System.out.println("No applicants for this job.");
        } else {
            for (Applicant applicant : applicants) {
                System.out.println(applicant);
            }
        }
    }

    public static void applyForJobFromApplicant() throws SQLException, ClassNotFoundException {
        System.out.print("Enter Applicant ID: ");
        int applicantId = sc.nextInt();
        System.out.print("Enter Job ID: ");
        int jobId = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Cover Letter: ");
        String coverLetter = sc.nextLine();

        boolean success = applicantDAO.applyForJob(applicantId, jobId, coverLetter);
        if (success) {
            System.out.println("Application submitted successfully!");
        } else {
            System.out.println("Failed to submit application.");
        }
    }

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("1. Show All Jobs");
            System.out.println("2. Post a Job");
            System.out.println("3. Create Applicant Profile");
            System.out.println("4. Apply for a Job");
            System.out.println("5. View Applicants for a Job");
            System.out.println("6. Apply for a Job (Applicant)");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            try {
                switch (choice) {
                    case 1:
                        getJobs();
                        break;
                    case 2:
                        postJob();
                        break;
                    case 3:
                        createProfile();
                        break;
                    case 4:
                        applyForJob();
                        break;
                    case 5:
                        getApplicants();
                        break;
                    case 6:
                        applyForJobFromApplicant();
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Choose something else from the given");
                }
            } catch (NegativeSalaryException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (InvalidEmailException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        } while (choice != 0);
    }
}
