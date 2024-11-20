package com.java.ecom.model;

import java.util.Date;

public class Customer {

    private int customerId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private Gender gender;
    private String address;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    private Date registrationDate;

    public Customer() {
    }

    public Customer(int customerId, String firstName, String lastName, String email, String password, String phone,
                    Gender gender, String address, String city, String state, String postalCode, String country,
                    Date registrationDate) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.gender = gender;
        this.address = address;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
        this.registrationDate = registrationDate;
    }

    // Getters and Setters
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }
    public Customer(int customerId, String email) {
        this.customerId = customerId;
        this.email = email;
    }
    @Override
    public String toString() {
        return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
                + email + ", password=" + password + ", phone=" + phone + ", gender=" + gender + ", address=" + address
                + ", city=" + city + ", state=" + state + ", postalCode=" + postalCode + ", country=" + country
                + ", registrationDate=" + registrationDate + "]";
    }
}