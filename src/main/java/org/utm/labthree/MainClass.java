package org.utm.labthree;

import java.io.File;
import java.io.IOException;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        String folderPath = "C:\\Users\\andre\\OneDrive\\Desktop\\againfolder\\src\\main\\java\\TestFolder";
        File folder = new File(folderPath);
        File[] files = folder.listFiles();

        for (File file : files) {
            if (file.isFile()) {
                System.out.println("File: " + file.getName());
                printFileTimes(file);
            }
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a command (e.g., 'commit C:\\path\\to\\file.txt'): ");
        String userInput = scanner.nextLine();

        if (userInput.toLowerCase().startsWith("commit ")) {
            handleCommitCommand(userInput.substring("commit ".length()));
        }scanner.close();

    }
    public static void handleCommitCommand(String filePath) {
        File fileToCommit = new File(filePath);

        if (fileToCommit.exists()) {
            updateLastModified(fileToCommit);
            System.out.println("File '" + fileToCommit.getName() + "' has been committed.");
            printFileTimes(fileToCommit);
        } else {
            System.out.println("File not found: " + filePath);
        }
    }






    public static void updateLastModified(File file) {
        long currentTime = System.currentTimeMillis();
        file.setLastModified(currentTime);
    }

    public static void printFileTimes(File file) {
        System.out.println("Created: " + getCreationTime(file.toPath()));
        System.out.println("Modified: " + new Date(file.lastModified()));
    }

    public static Date getCreationTime(Path path) {
        try {
            BasicFileAttributes attr = Files.readAttributes(path, BasicFileAttributes.class);
            FileTime fileTime = attr.creationTime();
            return new Date(fileTime.toMillis());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
