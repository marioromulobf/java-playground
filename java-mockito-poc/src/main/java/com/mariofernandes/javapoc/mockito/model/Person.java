package com.mariofernandes.javapoc.mockito.model;

import java.math.BigDecimal;

public class Person {
    private Long id;
    private String name;
    private Integer age;
    private String country;
    private String email;
    private String phoneNumber;
    private String occupation;
    private BigDecimal regularIncome;
    private BigDecimal irregularIncome;
    private String maritalStatus;
    private String educationLevel;

    public Person() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public BigDecimal getRegularIncome() {
        return regularIncome;
    }

    public void setRegularIncome(BigDecimal regularIncome) {
        this.regularIncome = regularIncome;
    }

    public BigDecimal getIrregularIncome() {
        return irregularIncome;
    }

    public void setIrregularIncome(BigDecimal irregularIncome) {
        this.irregularIncome = irregularIncome;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

}
