package org.utm.labtwo.commands.impl;

import org.utm.labtwo.commands.Command;
import org.utm.labtwo.models.Student;
import org.utm.labtwo.services.FacultyService;
import org.utm.labtwo.services.StudentService;

import java.util.List;

public class StudentCommand implements Command {

    private final StudentService studentService = new StudentService();

    private final FacultyService facultyService = new FacultyService();

    @Override
    public boolean isValidCommand(String[] commands, int requiredSize) {
        System.out.println(commands.length);
        return commands.length == requiredSize;
    }

    public void addStudent(String[] commandList) {
        var parametersSize = 8;
        if (isValidCommand(commandList, parametersSize)) {
            studentService.addStudent(commandList[1], commandList[2], commandList[3], commandList[4],
                    commandList[5], commandList[6], commandList[7]);
        } else {
            System.out.println("Error: Incorrect amount of parameters." + "Required amount of parameters " + (parametersSize - 1));
        }
    }

    public void displayEnrolledStudents(String[] commandList) {
        var parametersSize = 2;
        if (isValidCommand(commandList, parametersSize)) {
            List<Student> students = facultyService.getStudentsEnrolledToFaculty(commandList[1]);
            if (students == null || students.isEmpty()) {
                System.out.println("No enrolled students to this faculty ");
            } else {
                for (Student student : students) {
                    System.out.println(student);
                }
            }
        } else {
            System.out.println("Error: Incorrect amount of parameters." + "Required amount of parameters " + (parametersSize - 1));
        }
    }

    public void displayGraduatedStudents(String[] commandList) {
        var parametersSize = 2;
        if (isValidCommand(commandList, parametersSize)) {
            List<Student> students = facultyService.getStudentsGraduatedFromFaculty(commandList[1]);
            if (students == null || students.isEmpty()) {
                System.out.println("No graduated students to this faculty ");
            } else {
                for (Student student : students) {
                    System.out.println(student);
                }
            }
        } else {
            System.out.println("Error: Incorrect amount of parameters." + "Required amount of parameters " + (parametersSize - 1));
        }
    }

    public void graduateStudent(String[] commandList) {
        var parametersSize = 2;

        if (isValidCommand(commandList, parametersSize)) {
            studentService.graduateStudentFromUniversity(commandList[1]);
        } else {
            System.out.println("Error: Incorrect amount of parameters." + "Required amount of parameters " + (parametersSize - 1));
        }
    }
}
