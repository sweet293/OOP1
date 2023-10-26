package org.utm.labtwo.behaviour;

import org.utm.labtwo.commands.impl.FacultyCommand;
import org.utm.labtwo.commands.impl.StudentCommand;
import org.utm.labtwo.enums.MenuState;
import org.utm.labtwo.services.CommandService;
import org.utm.labtwo.utils.MenuHandler;

import java.util.Arrays;
import java.util.Scanner;

public class ApplicationLoop {

    private final FacultyCommand facultyCommand = new FacultyCommand();

    private final StudentCommand studentCommand = new StudentCommand();

    private final MenuHandler menuHandler = new MenuHandler();


    public void run() {
        Scanner scanner = new Scanner(System.in);
        String command = "";

        while (!command.equals("q")) {
            var currentState = menuHandler.getCurrentState();

            if (currentState == MenuState.MAIN) {
                CommandService.greetingMessage();
            } else if (currentState == MenuState.FACULTY) {
                CommandService.getFacultyOperations();
            } else if (currentState == MenuState.GENERAL) {
                CommandService.getGeneralOperations();
            } else {
                CommandService.greetingMessage();
            }

            System.out.println("Write Command> ");
            command = scanner.nextLine();
            String[] commandsList = command.split("/");

            switch (commandsList[0]) {
                case "f" -> {
                    System.out.println(Arrays.toString(commandsList));
                    menuHandler.setCurrentState(MenuState.FACULTY);
                }
                case "df" -> facultyCommand.displayAllFaculties();
                case "cf" -> facultyCommand.createFaculty(commandsList);
                case "b" -> menuHandler.setCurrentState(MenuState.MAIN);
                case "q" -> System.out.println("Shutting down...");
                case "cs" -> studentCommand.addStudent(commandsList);
                case "s", "g" -> menuHandler.setCurrentState(MenuState.GENERAL);
                case "dgs" -> studentCommand.displayGraduatedStudents(commandsList);
                case "des" -> studentCommand.displayEnrolledStudents(commandsList);
                case "gs" -> studentCommand.graduateStudent(commandsList);
                case "dfef" -> facultyCommand.displayFacultiesField(commandsList);
                case "bf" -> facultyCommand.checkStudentBelongsToFaculty(commandsList);
                case "ss" -> facultyCommand.searchStudentAndShowFaculty(commandsList);
                default -> System.out.println("Invalid Command");
            }
        }
        scanner.close();

    }

}


