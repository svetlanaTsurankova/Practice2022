package com.java.senla.view;

import java.util.Scanner;

public class MenuController {
    private Builder builder = new Builder();
    private Navigator navigator = new Navigator();
    ;

    public MenuController() {
    }

    public void run() {
        System.out.println(" Welcome to menu ");
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        navigator.setCurrentMenu(builder.getRootMenu());
        navigator.printMenu();

        while (!exit) {
            Integer choice = Integer.valueOf(scanner.nextLine());
            if (choice >= navigator.getCurrentMenu().getMenuItems().length) {
                System.out.println("Incorrect input");
                continue;
            } else {
                navigator.navigate(choice);
            }
            if (navigator.getCurrentMenu().getMenuItems()[choice].getNextMenu() == null) {
                exit = true;
                continue;
            }
            navigator.setCurrentMenu(navigator.getCurrentMenu().getMenuItems()[choice - 1].getNextMenu());
            navigator.printMenu();
        }

    }
}
