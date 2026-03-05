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

    public static class Builder {
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

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withAge(Integer age) {
            this.age = age;
            return this;
        }

        public Builder withCountry(String country) {
            this.country = country;
            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder withPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder withOccupation(String occupation) {
            this.occupation = occupation;
            return this;
        }

        public Builder withRegularIncome(BigDecimal regularIncome) {
            this.regularIncome = regularIncome;
            return this;
        }

        public Builder withIrregularIncome(BigDecimal irregularIncome) {
            this.irregularIncome = irregularIncome;
            return this;
        }

        public Builder withMaritalStatus(String maritalStatus) {
            this.maritalStatus = maritalStatus;
            return this;
        }

        public Builder withEducationLevel(String educationLevel) {
            this.educationLevel = educationLevel;
            return this;
        }

        public Person build() {
            Person person = new Person();
            person.setId(id);
            person.setName(name);
            person.setAge(age);
            person.setCountry(country);
            person.setEmail(email);
            person.setPhoneNumber(phoneNumber);
            person.setOccupation(occupation);
            person.setRegularIncome(regularIncome);
            person.setIrregularIncome(irregularIncome);
            person.setMaritalStatus(maritalStatus);
            person.setEducationLevel(educationLevel);
            return person;
        }
    }
}
