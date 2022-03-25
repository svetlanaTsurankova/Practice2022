package com.java.senla.controller.room;

import com.java.senla.model.service.ManagerHotel;
import com.java.senla.model.service.impl.ManagerRoom;
import com.java.senla.view.IAction;

import java.util.Scanner;

public class ShowDetailsOfRoom implements IAction {
    Scanner scanner = new Scanner(System.in);
    ManagerRoom managerRoom = new ManagerRoom();
    ManagerHotel managerHotel = new ManagerHotel();

    @Override
    public void execute() {
        System.out.print("Input number room 1 - 10 : ");
        managerHotel.printDetailsOfRoom(managerRoom.getRoomById(scanner.nextInt()));
    }
}