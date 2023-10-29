package org.utm.labthree;
import java.text.SimpleDateFormat;
public class SnapshotManager {
    public void takeSnapshot() {
        // Get the current time in milliseconds
        long currentTime = System.currentTimeMillis();
        // Update the snapshot time
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Snapshot updated to time: " + dateFormat.format(currentTime));
    }
}
