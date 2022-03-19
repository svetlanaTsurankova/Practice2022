package com.java.senla.view;

import java.util.Scanner;

public class MenuController {
    private Builder builder = new Builder();
    private Navigator navigator = new Navigator();

    public MenuController() {
    }

    public void run() {
        System.out.println(" Welcome to menu ");
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        navigator.setCurrentMenu(builder.getRootMenu());
        navigator.printMenu();

        while (!exit) {
            int choice = Integer.parseInt(scanner.nextLine());
            MenuItem[] item = navigator.getCurrentMenu().getMenuItems();
            if (choice >= item.length) {
                System.out.println("Incorrect input");
                continue;
            } else {
                navigator.navigate(choice);
            }
            if (item[choice-1].getNextMenu() == null) {
                exit = true;
                continue;
            }
            navigator.setCurrentMenu(item[choice - 1].getNextMenu());
            navigator.printMenu();
        }

    }
}
