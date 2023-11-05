package org.utm.labthree;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StatusManager {
    public StatusManager() {
    }

    public static void displaySnapshotStatus(String snapshotFilePath, String targetFolderPath) {
        try {
            FileReader snapshotFileReader = new FileReader(snapshotFilePath);
            BufferedReader snapshotBufferedReader = new BufferedReader(snapshotFileReader);

            System.out.println("Created Snapshot at: ");
            String snapshotLine = snapshotBufferedReader.readLine();
            if (snapshotLine != null) {
                System.out.println(snapshotLine);
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date snapshotTime = dateFormat.parse(snapshotLine);

                File targetFolder = new File(targetFolderPath);
                if (targetFolder.isDirectory()) {
                    File[] files = targetFolder.listFiles();
                    if (files != null) {
                        List<String> changedFiles = new ArrayList<>();
                        List<String> notChangedFiles = new ArrayList<>();

                        for (File file : files) {
                            long lastModified = file.lastModified();
                            if (lastModified > snapshotTime.getTime()) {
                                changedFiles.add(file.getName());
                            } else {
                                notChangedFiles.add(file.getName());
                            }
                        }


                        for (String changedFile : changedFiles) {
                            System.out.println(changedFile + " - Changed");
                        }


                        for (String notChangedFile : notChangedFiles) {
                            System.out.println(notChangedFile + " - Not Changed");
                        }
                    }
                }
            }

            snapshotBufferedReader.close();
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file or retrieving file information: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An error occurred while parsing dates: " + e.getMessage());
        }
    }
}
