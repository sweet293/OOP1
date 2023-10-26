package org.utm.labtwo.models;

public class Student {

    private final String facultyAbbreviation;

    private final String firstName;

    private final String lastName;

    private final String email;

    private final String day;

    private final String month;

    private final String year;

    private boolean isGraduated;

    public Student(String facultyAbbreviation, String firstName, String lastName, String email, String day, String month, String year, boolean isGraduated) {

        this.facultyAbbreviation = facultyAbbreviation;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.day = day;
        this.month = month;
        this.year = year;
        this.isGraduated = isGraduated;
    }

    public void setGraduated(boolean graduated) {
        isGraduated = graduated;
    }

    public boolean isGraduated() {
        return isGraduated;
    }

    public String getFacultyAbbreviation() {
        return facultyAbbreviation;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getDay() {
        return day;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }

    @Override
    public String toString() {
        return
                "facultyAbbreviation='" + facultyAbbreviation + '\'' +
                        ", firstName='" + firstName + '\'' +
                        ", lastName='" + lastName + '\'' +
                        ", email='" + email + '\'' +
                        ", day='" + day + '\'' +
                        ", month='" + month + '\'' +
                        ", year='" + year + '\'';
    }
}