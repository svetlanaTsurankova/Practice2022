package com.java.senla.view;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Menu {
    private String name;
    private MenuItem[] menuItems=new MenuItem[15];

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MenuItem[] getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(MenuItem[] menuItems) {
        this.menuItems = menuItems;
    }

    public Menu(String name) {
        this.name = name;
    }


    public int getCountMenu() {
        int count = 0;
        for (int i = 0; i < menuItems.length; i++) {
            if (menuItems[i] != null) {
                count++;
            }
        }
        return count;
    }

    public void addMenuItem(MenuItem menuItem) {
        if (menuItem != null) {
            menuItems[getCountMenu()] = menuItem;
        }
    }
}
