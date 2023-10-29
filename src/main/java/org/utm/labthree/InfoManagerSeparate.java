package org.utm.labthree;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class InfoManagerSeparate {
    private final String folderPath = "C:\\Users\\andre\\OneDrive\\Desktop\\againfolder\\src\\main\\java\\TestFolder";

    public void displayFileSeparateInfo(String filename) {
        File file = new File(folderPath + File.separator + filename);

        if (file.exists() && file.isFile()) {
            String extension = getFileExtension(filename);

            if (extension.equals("txt")) {
                displayTextFileInfo(file);
            } else if (extension.equals("png")) {
                displayImageFileInfo(file);
            } else if (extension.equals("py")) {
                displayPythonFileInfo(file);
            } else {
                System.out.println("Unsupported file extension: " + extension);
            }
        } else {
            System.out.println("File not found: " + filename);
        }
    }

    private String getFileExtension(String filename) {
        int lastDotIndex = filename.lastIndexOf('.');
        if (lastDotIndex > 0 && lastDotIndex < filename.length() - 1) {
            return filename.substring(lastDotIndex + 1).toLowerCase();
        }
        return "";
    }

    private void displayTextFileInfo(File file) {
        try {
            Scanner scanner = new Scanner(file);
            int lineCount = 0;
            int wordCount = 0;
            int characterCount = 0;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                lineCount++;
                wordCount += line.split("\\s+").length;
                characterCount += line.length();
            }

            System.out.println("Text File Information:");
            System.out.println("Line Count: " + lineCount);
            System.out.println("Word Count: " + wordCount);
            System.out.println("Character Count: " + characterCount);
        } catch (IOException e) {
            System.out.println("Error reading the text file: " + e.getMessage());
        }
    }

    private void displayImageFileInfo(File file) {
        long fileSize = file.length();
        System.out.println("Image File Information:");
        System.out.println("File Size: " + fileSize + " bytes");
    }

    private void displayPythonFileInfo(File file) {
        try {
            Scanner scanner = new Scanner(file);
            int lineCount = 0;
            int classCount = 0;
            int methodCount = 0;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();

                if (line.startsWith("class ")) {
                    classCount++;
                } else if (line.startsWith("def ")) {
                    methodCount++;
                }

                lineCount++;
            }

            System.out.println("Python File Information:");
            System.out.println("Line Count: " + lineCount);
            System.out.println("Class Count: " + classCount);
            System.out.println("Method Count: " + methodCount);
        } catch (IOException e) {
            System.out.println("Error reading the Python file: " + e.getMessage());
        }
    }}