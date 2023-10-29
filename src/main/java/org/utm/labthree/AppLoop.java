package org.utm.labthree;

import java.util.Scanner;

public class AppLoop {
    private SnapshotManager snapshotManager = new SnapshotManager();
    public void run() {
        boolean exit = false;
        Scanner scanner = new Scanner(System.in);
        String command = "";

        while (!exit) {
            System.out.println("Main Menu:");
            System.out.println("Commit");
            System.out.println("Info");
            System.out.println("Status");
            System.out.println("Exit");
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
                        System.out.println("all");
                        System.out.println("<filename>");
                        System.out.println("b - back to Main Menu");
                        System.out.print("Choose an option: ");
                        String infoChoice = scanner.nextLine();
                        switch (infoChoice) {
                            case "all":
                                InfoManagerAll infoManager = new InfoManagerAll();
                                infoManager.displayAllFileInfo();
                                break;
                            case "<filename>":
                                String filename = scanner.nextLine();
                                InfoManagerSeparate infoManagerSeparate = new InfoManagerSeparate();
                                infoManagerSeparate.displayFileSeparateInfo(filename);
                                break;
                            case "b":
                                infoSubMenu = false;
                                break;
                            default:
                                System.out.println("Invalid option. Please try again.");
                                break;
                        }
                    }
                    break;
                case "status":
                    StatusManager statusManager = new StatusManager();
                    String snapshotTime = SnapshotManager.getSnapshotTime();
                    statusManager.checkStatus(snapshotTime);
                    break;
                case "exit":
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }}
            scanner.close();
        }}