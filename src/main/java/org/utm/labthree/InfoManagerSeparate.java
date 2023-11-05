package org.utm.labthree;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class InfoManagerSeparate {
    public void getInfoForFile(String filePath) {
        File file = new File(filePath);

        if (file.isFile() && file.exists()) {
            String fileName = file.getName();

            if (isImageFile(fileName)) {
                getImageInfo(file);
            } else if (isTextFile(fileName)) {
                getTextFileInfo(file);
            } else if (isProgramFile(fileName)) {
                getProgramFileInfo(file);
            } else {
                System.out.println("Unsupported file type: " + fileName);
            }
        } else {
            System.out.println("File not found: " + filePath);
        }
    }

    private boolean isImageFile(String fileName) {
        return fileName.toLowerCase().endsWith(".jpg") || fileName.toLowerCase().endsWith(".jpeg")
                || fileName.toLowerCase().endsWith(".png") || fileName.toLowerCase().endsWith(".gif");
    }

    private boolean isTextFile(String fileName) {
        return fileName.toLowerCase().endsWith(".txt");
    }

    private boolean isProgramFile(String fileName) {
        return fileName.toLowerCase().endsWith(".java") || fileName.toLowerCase().endsWith(".py");
    }

    private void getImageInfo(File file) {
        try {
            BufferedImage image = ImageIO.read(file);
            int width = image.getWidth();
            int height = image.getHeight();
            System.out.println("Image Size: " + width + "x" + height);
        } catch (IOException e) {
            System.err.println("Error reading image file: " + e.getMessage());
        }
    }

    private void getTextFileInfo(File file) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            int lineCount = 0;
            int wordCount = 0;
            int charCount = 0;

            String line;
            while ((line = reader.readLine()) != null) {
                lineCount++;
                String[] words = line.split("\\s+");
                wordCount += words.length;
                charCount += line.length();
            }

            reader.close();

            System.out.println("Line Count: " + lineCount);
            System.out.println("Word Count: " + wordCount);
            System.out.println("Character Count: " + charCount);
        } catch (IOException e) {
            System.err.println("Error reading text file: " + e.getMessage());
        }
    }

    private void getProgramFileInfo(File file) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            int lineCount = 0;
            int classCount = 0;
            int methodCount = 0;

            String line;
            while ((line = reader.readLine()) != null) {
                lineCount++;
                if (line.contains("class ")) {
                    classCount++;
                }
                if (line.contains("void ") || line.contains(" int ") || line.contains(" double ") || line.contains("def ")) {
                    methodCount++;
                }
            }

            reader.close();

            System.out.println("Line Count: " + lineCount);
            System.out.println("Class Count: " + classCount);
            System.out.println("Method Count: " + methodCount);
        } catch (IOException e) {
            System.err.println("Error reading program file: " + e.getMessage());
        }
    }
}
