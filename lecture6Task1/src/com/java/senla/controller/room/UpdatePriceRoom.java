package com.java.senla.controller.room;

import com.java.senla.model.service.ManagerHotel;
import com.java.senla.model.service.impl.ManagerRoom;
import com.java.senla.view.IAction;

import java.util.Scanner;

public class UpdatePriceRoom implements IAction {
    ManagerRoom managerRoom = new ManagerRoom();
    ManagerHotel managerHotel = new ManagerHotel();
    Scanner scanner = new Scanner(System.in);

    @Override
    public void execute() {
        System.out.println("input id room 1..10 : ");
        Integer number = scanner.nextInt();
        System.out.println("input price room : ");
        double price = scanner.nextDouble();
        managerHotel.changePriceRoom(managerRoom.getRoomById(number), price);
        managerHotel.printDetailsOfRoom(managerRoom.getRoomById(number));
    }
}