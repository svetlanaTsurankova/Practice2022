package com.java.senla.view;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private String name;
    private List<MenuItem> menuItems = new ArrayList<MenuItem>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public Menu(String name) {
        this.name = name;
    }

    public int getCountMenu() {
        int count = 0;
        for (MenuItem menuItem : menuItems) {
            if (menuItem != null) {
                count++;
            }
        }
        return count;
    }

    public void addMenuItem(MenuItem menuItem) {
        if (menuItem != null) {
            menuItems.add(menuItem);
        }
    }
}