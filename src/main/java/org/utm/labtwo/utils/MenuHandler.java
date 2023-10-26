package org.utm.labtwo.utils;

import org.utm.labtwo.enums.MenuState;

public class MenuHandler {

    private MenuState currentState;

    public MenuState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(MenuState currentState) {
        this.currentState = currentState;
    }

}
