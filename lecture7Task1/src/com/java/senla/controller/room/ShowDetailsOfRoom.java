package com.java.senla.controller.room;

import com.java.senla.model.service.ManagerHotel;
import com.java.senla.view.IAction;

import java.util.Scanner;

public class ShowDetailsOfRoom implements IAction {
    Scanner scanner = new Scanner(System.in);

    @Override
    public void execute() {
        System.out.print("Input number room 1 - 10 : ");
        ManagerHotel.managerHotel().printDetailsOfRoom(scanner.nextInt());
    }
}