package com.java.senla.controller.room;

import com.java.senla.model.service.ManagerHotel;
import com.java.senla.model.service.impl.ManagerRoom;
import com.java.senla.view.IAction;

import java.util.Scanner;

public class UpdateStatusRoom implements IAction {
    ManagerRoom managerRoom = new ManagerRoom();
    Scanner scanner = new Scanner(System.in);

    @Override
    public void execute() {
        System.out.println("input id room 1..10 : ");
        ManagerHotel.managerHotel().changeStatusRoom(managerRoom.getRoomById(scanner.nextInt()));
    }
}
