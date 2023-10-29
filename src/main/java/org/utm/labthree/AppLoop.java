package org.utm.labthree;

import java.util.Arrays;
import java.util.Scanner;

public class AppLoop {

    public void run() {
        boolean exit = false;
        Scanner scanner = new Scanner(System.in);
        String command = "";

        while (!exit) {
            System.out.println("Main Menu:");
            System.out.println("1. Commit");
            System.out.println("2. Info");
            System.out.println("3. Status");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "commit":
                    SnapshotManager snapshotManager = new SnapshotManager();
                    snapshotManager.takeSnapshot();
                    break;
                case "info":
                    boolean infoSubMenu = true;
                    while (infoSubMenu) {
                        System.out.println("Info Menu:");
                        System.out.println("1. All");
                        System.out.println("2. <filename>");
                        System.out.println("3. Back to Main Menu");
                        System.out.print("Choose an option: ");
                        String infoChoice = scanner.nextLine();
                        switch (infoChoice) {
                            case "all":
                                System.out.println("Displaying all info...");
                                break;
                            case "<filename>":
                                System.out.print("Enter the filename: ");
                                String filename = scanner.nextLine();
                                System.out.println("Displaying info for " + filename);
                                break;
                            case "3":
                                infoSubMenu = false;
                                break;
                            default:
                                System.out.println("Invalid option. Please try again.");
                                break;
                        }
                    }
                    break;
                case "status":
                    System.out.println("Displaying status...");
                    break;
                case "4":
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }}
            scanner.close();

        }}


