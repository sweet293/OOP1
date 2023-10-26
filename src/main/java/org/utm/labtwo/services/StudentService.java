package org.utm.labtwo.services;

import org.utm.labtwo.behaviour.FileManager;
import org.utm.labtwo.models.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentService {

    private final FileManager fileManager = new FileManager("students.txt");

    private final FacultyService facultyService = new FacultyService();

    public void addStudent(String facultyAbbreviation, String firstName, String lastName, String email, String day, String month, String year) {
        var faculty = facultyService.getFacultyByAbbreviation(facultyAbbreviation);
        var student = getStudentByEmail(email);
        try {
            if (faculty == null) {
                System.out.println("Faculty " + facultyAbbreviation + " does not exist");
            } else if (student != null) {
                System.out.println("Student " + email + " already exists");
            } else {
                String newStudent = facultyAbbreviation + "," +
                        firstName + "," + lastName + "," +
                        email + "," + day + "," +
                        month + "," + year + "," + "false" + "\n";
                fileManager.saveData(newStudent, true);

                System.out.println("Student " + email + " was successfully created");
            }
        } catch (Exception e) {
            System.out.println("Error during saving student");
        }
    }

    public List<Student> getAllStudents() {
        var partsData = fileManager.getData();

        List<Student> students = new ArrayList<>();

        if (!partsData.isEmpty()) {
            for (String[] parts : partsData) {
                Student student = new Student(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], parts[6], Boolean.parseBoolean(parts[7]));
                students.add(student);
            }
        }
        return students;
    }

    public Student getStudentByEmail(String email) {
        var students = getAllStudents();
        return students.stream()
                .filter(student -> student.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }

    public void graduateStudentFromUniversity(String email) {
        Student student = getStudentByEmail(email);
        if (student == null) {
            System.out.println("Student " + email + " does not exist");
        } else if (student.isGraduated()) {
            System.out.println("Error: Student " + email + " is already graduated");
        } else {
            List<Student> students = getAllStudents();

            for (Student st : students) {
                if (st.getEmail().equals(email)) {
                    st.setGraduated(true);
                    break;
                }
            }

            fileManager.overrideData(students);
            System.out.println("Student " + email + " was successfully graduated");
        }

    }
}
