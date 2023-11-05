package org.utm.labthree;
import java.io.File;
import java.io.IOException;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InfoManagerAll {
    public static void listFilesInfo(String directoryPath) {
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                System.out.println("File Name: " + file.getName());
                System.out.println("Pretty Print Extension: " + getPrettyPrintExtension(file.getName()));
                System.out.println("Created Date: " + getCreationTime(file.toPath()));
                System.out.println("Updated Date: " + getFormattedDateTime(file.lastModified()));
                System.out.println();
            }
        }
    }

    private static String getPrettyPrintExtension(String fileName) {
        int lastIndex = fileName.lastIndexOf('.');
        if (lastIndex >= 0 && lastIndex < fileName.length() - 1) {
            return fileName.substring(lastIndex + 1);
        }
        return "";
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
    private static String getFormattedDateTime(long timestamp) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(timestamp);
        return dateFormat.format(date);
    }
}
