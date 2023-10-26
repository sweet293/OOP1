package org.utm.labtwo.models;

import org.utm.labtwo.enums.EnumField;

import java.util.List;

public class Faculty {

    String facultyName;

    String facultyAbbreviation;

    EnumField studyField;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    private List<Student> students;


    public Faculty(String facultyName, String facultyAbbreviation, EnumField studyField) {
        this.facultyName = facultyName;
        this.facultyAbbreviation = facultyAbbreviation;
        this.studyField = studyField;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public String getFacultyAbbreviation() {
        return facultyAbbreviation;
    }

    public EnumField getField() {
        return studyField;
    }

    public String toString() {
        return "Faculty{" +
                "name='" + facultyName + '\'' +
                ", abbreviation='" + facultyAbbreviation + '\'' +
                ", studyField=" + studyField +
                '}';
    }


}