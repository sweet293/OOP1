package org.utm.labtwo.commands.impl;

import org.utm.labtwo.commands.Command;
import org.utm.labtwo.services.FacultyService;

public class FacultyCommand implements Command {

    private final FacultyService facultyService = new FacultyService();

    @Override
    public boolean isValidCommand(String[] commands, int requiredSize) {
        System.out.println(commands.length);
        return commands.length == requiredSize;
    }

    public void createFaculty(String[] commandList) {
        var parametersSize = 4;
        if (isValidCommand(commandList, parametersSize)) {
            facultyService.addFaculty(commandList[1], commandList[2], commandList[3]);
        } else {
            System.out.println("Error: Incorrect amount of parameters." + "Required amount of parameters " + (parametersSize - 1));
        }
    }

    public void displayAllFaculties() {
        var faculties = facultyService.getAllFaculties();
        System.out.println("Faculties: ");
        for (var faculty : faculties) {
            System.out.println(faculty);
        }
    }

    public void displayFacultiesField(String[] commandList) {
        var parametersSize = 2;
        if (isValidCommand(commandList, parametersSize)) {
            var faculties = facultyService.getAllFacultiesByField(commandList[1]);
            if (faculties.isEmpty()) {
                System.out.println("No faculties with field " + commandList[1]);
            } else {
                System.out.println("Faculties with field " + commandList[1] + ": ");
                for (var faculty : faculties) {
                    System.out.println(faculty);
                }
            }
        } else {
            System.out.println("Error: Incorrect amount of parameters." + "Required amount of parameters " + (parametersSize - 1));
        }
    }

    public void searchStudentAndShowFaculty(String[] commandList) {
        var parametersSize = 2;
        if (isValidCommand(commandList, parametersSize)) {
            var faculty = facultyService.getStudentBelongingToFaculty(commandList[1]);
            if (faculty == null) {
                System.out.println("Student with email " + commandList[1] + " does not exist");
            } else {
                System.out.println("Faculty of student with email " + commandList[1] + " is " + faculty.getFacultyName());
            }
        } else {
            System.out.println("Error: Incorrect amount of parameters." + "Required amount of parameters " + (parametersSize - 1));
        }
    }

    public void checkStudentBelongsToFaculty(String[] commandList) {
        var parametersSize = 3;
        if (isValidCommand(commandList, parametersSize)) {
            var faculty = facultyService.getStudentBelongingToFaculty(commandList[2]);

            if (faculty == null || !faculty.getFacultyAbbreviation().equals(commandList[2])) {
                System.out.println("Student " + commandList[2] + " does not belong to this faculty");
            } else {
                System.out.println("Student " + commandList[2] + " belongs to this faculty");
            }
        } else {
            System.out.println("Error: Incorrect amount of parameters." + "Required amount of parameters " + (parametersSize - 1));
        }
    }
}
