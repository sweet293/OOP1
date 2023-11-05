package org.utm.labthree;

import java.util.Scanner;

public class AppLoop {
    public void run() {
        boolean exit = false;
        Scanner scanner = new Scanner(System.in);
        String command = "";

        String snapshotFilePath = "C:\\Users\\andre\\OneDrive\\Desktop\\againfolder\\src\\main\\resources\\snapshot.txt";
        String targetFolderPath = "C:\\Users\\andre\\OneDrive\\Desktop\\againfolder\\src\\main\\java\\TestFolder";

        SnapshotManager SnapshotManager = new SnapshotManager("C:\\Users\\andre\\OneDrive\\Desktop\\againfolder\\src\\main\\resources\\snapshot.txt");
        InfoManagerAll InfoManagerAll = new InfoManagerAll();
        InfoManagerSeparate InfoManagerSeparate = new InfoManagerSeparate();
        StatusManager statusManager = new StatusManager();


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
                    SnapshotManager.writeSnapshot();
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
                                InfoManagerAll.listFilesInfo("C:\\Users\\andre\\OneDrive\\Desktop\\againfolder\\src\\main\\java\\TestFolder");
                                break;
                            case "<filename>":
                                System.out.print("Enter the filename: ");
                                String filename = scanner.nextLine();
                                InfoManagerSeparate.getInfoForFile("C:\\Users\\andre\\OneDrive\\Desktop\\againfolder\\src\\main\\java\\TestFolder\\" + filename);
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
                    StatusManager.displaySnapshotStatus(snapshotFilePath, targetFolderPath);
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