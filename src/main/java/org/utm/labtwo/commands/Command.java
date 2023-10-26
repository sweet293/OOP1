package org.utm.labtwo.commands;

public interface Command {

    boolean isValidCommand(String[] commands, int requiredSize);
}
