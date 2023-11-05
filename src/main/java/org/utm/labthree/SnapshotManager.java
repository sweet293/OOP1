package org.utm.labthree;
import java.text.SimpleDateFormat;
import java.io.*;
import java.util.Date;
public class SnapshotManager {

    private String filePath;

    public SnapshotManager(String filePath) {
        this.filePath = filePath;
    }

    public void writeSnapshot() {
        try {
            FileWriter fileWriter = new FileWriter(filePath); // Open in write mode (not append)
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date now = new Date();
            String dateTime = dateFormat.format(now);

            bufferedWriter.write(dateTime);
            bufferedWriter.close();

            System.out.println("Snapshot updated to: " + dateTime);
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
}