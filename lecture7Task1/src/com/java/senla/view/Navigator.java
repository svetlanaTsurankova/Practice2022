package com.java.senla.view;

import java.util.List;

public class Navigator {
    private Menu currentMenu;

    public Menu getCurrentMenu() {
        return currentMenu;
    }

    public void setCurrentMenu(Menu currentMenu) {
        this.currentMenu = currentMenu;
    }

    public Navigator() {
    }

    public void printMenu() {
        System.out.println(currentMenu.getName());
        List<MenuItem> items = currentMenu.getMenuItems();
        int i = 1;
        for (MenuItem item : items) {
            if (item != null) {
                System.out.println(i + "  " + item.getTitle());
                i++;
            }
        }
    }

    public void navigate(int index) {
        List<MenuItem> items = currentMenu.getMenuItems();
        if (items.get(index).getAction() != null) {
            items.get(index).doAction();
        } else {
            items.get(index).getNextMenu();
        }
    }
}
