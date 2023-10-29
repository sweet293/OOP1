package org.utm.labthree;
import java.text.SimpleDateFormat;
public class SnapshotManager {
    private static String snapshotTime = null;

    public void takeSnapshot() {
        // Get the current time in milliseconds
        long currentTime = System.currentTimeMillis();

        // Update the snapshot time
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        snapshotTime = dateFormat.format(currentTime);

        System.out.println("Snapshot updated to time: " + snapshotTime);
    }

    public static String getSnapshotTime() {
        return snapshotTime;
    }
}
