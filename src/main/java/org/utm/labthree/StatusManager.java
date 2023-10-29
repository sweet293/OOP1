package org.utm.labthree;
import java.io.File;
import java.text.SimpleDateFormat;
public class StatusManager {
    private final String folderPath = "C:\\Users\\andre\\OneDrive\\Desktop\\againfolder\\src\\main\\java\\TestFolder";
    public void checkStatus(String snapshotTime) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        File folder = new File(folderPath);

        if (folder.exists() && folder.isDirectory()) {
            checkFolderStatus(folder, snapshotTime, dateFormat);
        } else {
            System.out.println("Folder not found: " + folderPath);
        }
    }


    private void checkFolderStatus(File folder, String snapshotTime, SimpleDateFormat dateFormat) {
        File[] files = folder.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    checkFileStatus(file, snapshotTime, dateFormat);
                } else if (file.isDirectory()) {
                    checkFolderStatus(file, snapshotTime, dateFormat);
                }
            }
        }
        }


    private void checkFileStatus(File file, String snapshotTime, SimpleDateFormat dateFormat) {
        if (snapshotTime == null) {
            System.out.println(file.getName() + " - Snapshot time not available");
            return;
        }

        try {
            long lastModifiedTime = file.lastModified();
            boolean changed = lastModifiedTime > Long.parseLong(snapshotTime);
            String changeStatus = changed ? "Changed" : "Not Changed";
            System.out.println(file.getName() + " - " + changeStatus);
        } catch (NumberFormatException e) {
            System.out.println(file.getName() + " - Invalid snapshot time format");
        }
    }
}
