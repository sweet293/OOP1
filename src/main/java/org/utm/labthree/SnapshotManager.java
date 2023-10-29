package org.utm.labthree;

public class SnapshotManager {
    public void takeSnapshot() {
        // Get the current time in milliseconds
        long currentTime = System.currentTimeMillis();
        // Update the snapshot time
        System.out.println("Snapshot updated to time: " + currentTime);
    }
}
