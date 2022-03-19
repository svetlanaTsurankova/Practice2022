package com.java.senla.view;

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
        MenuItem[] items = currentMenu.getMenuItems();
        int i = 1;
        for (MenuItem item : items) {
            if (item != null) {
                System.out.println(i + "  " + item.getTitle());
                i++;
            }
        }
    }

    public void navigate(int index) {
        MenuItem[] items = currentMenu.getMenuItems();
        if (items[index - 1].getAction() != null) {
            items[index - 1].doAction();
        } else {
            items[index - 1].getNextMenu();
        }
    }
}