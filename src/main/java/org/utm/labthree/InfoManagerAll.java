package org.utm.labthree;
import java.io.File;
import java.io.IOException;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;

public class InfoManagerAll {
    private final String folderPath = "C:\\Users\\andre\\OneDrive\\Desktop\\againfolder\\src\\main\\java\\TestFolder";

    public void displayAllFileInfo() {
        File directory = new File(folderPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("File Name: " + file.getName());
                    String prettyPrintExtension = getPrettyPrintExtension(file.getName());
                    System.out.println("Pretty Print Extension: " + prettyPrintExtension);
                    System.out.println("Created: " + getCreationTime(file.toPath()));
                    System.out.println("Last Modified: " + new Date(file.lastModified()));
                    System.out.println();
                }
            }
        } else {
            System.out.println("Directory not found or empty.");
        }
    }

    private String getPrettyPrintExtension(String fileName) {
        int lastDotIndex = fileName.lastIndexOf('.');
        if (lastDotIndex > 0 && lastDotIndex < fileName.length() - 1) {
            return fileName.substring(lastDotIndex + 1).toUpperCase();
        }
        return "No extension";
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

    public static void updateLastModified(File file) {
        long currentTime = System.currentTimeMillis();
        file.setLastModified(currentTime);
    }
}