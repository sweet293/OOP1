package org.utm.labtwo.services;

import org.utm.labtwo.behaviour.FileManager;
import org.utm.labtwo.enums.EnumField;
import org.utm.labtwo.models.Faculty;
import org.utm.labtwo.models.Student;
import org.utm.labtwo.utils.StudyField;

import java.util.ArrayList;
import java.util.List;

public class FacultyService {

    private final FileManager fileManager = new FileManager("faculties.txt");

    private final FileManager studentManager = new FileManager("students.txt");


    public List<Faculty> getAllFaculties() {
        var partsData = fileManager.getData();

        List<Faculty> faculties = new ArrayList<>();

        if (!partsData.isEmpty()) {
            for (String[] parts : partsData) {
                Faculty faculty = new Faculty(parts[0], parts[1], EnumField.valueOf(parts[2]));
                faculties.add(faculty);
            }
        }

        return faculties;
    }


    public void addFaculty(String FacultyName, String abbreviation, String studyField) {
        if (StudyField.checkStudyField(studyField)) {
            if (getFacultyByAbbreviation(abbreviation) != null) {
                System.out.println("Faculty " + abbreviation + " already exists");
                return;
            }

            EnumField studyFieldEnum = EnumField.valueOf(studyField);

            String formattedData = FacultyName + "," +
                    abbreviation + "," + studyFieldEnum.name() + "\n";

            fileManager.saveData(formattedData, true);

            System.out.println("Faculty created successfully.");
        }
    }

    public Faculty getFacultyByAbbreviation(String facultyAbbreviation) {
        var faculties = getAllFaculties();
        return faculties.stream()
                .filter(faculty -> faculty.getFacultyAbbreviation().equals(facultyAbbreviation))
                .findFirst()
                .orElse(null);
    }

    public Faculty getFullFacultyByAbbreviation(String facultyAbbreviation) {
        var partsData = studentManager.getData();
        List<Student> studentsAll = new ArrayList<>();

        if (!partsData.isEmpty()) {
            for (String[] parts : partsData) {
                Student student = new Student(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], parts[6], Boolean.parseBoolean(parts[7]));
                studentsAll.add(student);
            }
        }

        var faculty = getFacultyByAbbreviation(facultyAbbreviation);

        if (faculty != null) {
            var studentsEnrolledToFaculty = studentsAll.stream()
                    .filter(student -> student.getFacultyAbbreviation().equals(faculty.getFacultyAbbreviation()))
                    .toList();

            var facultyCombined = new Faculty(faculty.getFacultyName(), faculty.getFacultyAbbreviation(), faculty.getField());
            facultyCombined.setStudents(studentsEnrolledToFaculty);
            return facultyCombined;
        } else {
            System.out.println("Faculty with abbreviation " + facultyAbbreviation + " does not exist");
            return null;
        }
    }

    public List<Faculty> getAllFacultiesByField(String studyField) {
        if (StudyField.checkStudyField(studyField)) {
            var faculties = getAllFaculties();
            return faculties.stream()
                    .filter(faculty -> faculty.getField().name().equals(studyField))
                    .toList();
        }
        return new ArrayList<>();
    }

    public Faculty getStudentBelongingToFaculty(String studentEmail) {
        var faculties = getAllFaculties();
        List<Faculty> faculties2 = new ArrayList<>();
        for (var faculty : faculties) {
            faculties2.add(getFullFacultyByAbbreviation(faculty.getFacultyAbbreviation()));
        }

        Faculty foundFaculty = null;

        for (Faculty faculty : faculties2) {
            List<Student> students = faculty.getStudents();

            if (students != null) {
                for (Student student : students) {
                    if (student.getEmail().equals(studentEmail) && !student.isGraduated()) {
                        foundFaculty = faculty;
                        break;
                    }
                }
            }

            if (foundFaculty != null) {
                break;
            }
        }

        return foundFaculty;
    }

    public List<Student> getStudentsEnrolledToFaculty(String facultyAbbreviation) {
        Faculty faculty = getFullFacultyByAbbreviation(facultyAbbreviation);
        if (faculty != null) {
            List<Student> enrolledStudents = new ArrayList<>();
            var students = faculty.getStudents();
            if (students != null) {
                for (Student student : students) {
                    if (!student.isGraduated()) {
                        enrolledStudents.add(student);
                    }
                }
            }
            return enrolledStudents;
        }
        return null;
    }

    public List<Student> getStudentsGraduatedFromFaculty(String facultyAbbreviation) {
        Faculty faculty = getFullFacultyByAbbreviation(facultyAbbreviation);
        if (faculty != null) {
            List<Student> graduatedStudents = new ArrayList<>();
            var students = faculty.getStudents();
            if (students != null) {
                for (Student student : students) {
                    if (student.isGraduated()) {
                        graduatedStudents.add(student);
                    }
                }
            }
            return graduatedStudents;
        }
        return null;
    }


}
