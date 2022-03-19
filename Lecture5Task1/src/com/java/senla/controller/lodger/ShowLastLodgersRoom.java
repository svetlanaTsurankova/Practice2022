package com.java.senla.controller.lodger;

import com.java.senla.model.service.ManagerHotel;
import com.java.senla.model.service.impl.ManagerRoom;
import com.java.senla.view.IAction;

import java.util.Scanner;

public class ShowLastLodgersRoom implements IAction {
    ManagerHotel managerHotel = new ManagerHotel();
    ManagerRoom managerRoom = new ManagerRoom();
    Scanner scanner = new Scanner(System.in);

    @Override
    public void execute() {
        System.out.print("Input the room id ...");
        managerHotel.showLastLodgersRoom(managerRoom.getRoomByNumber(scanner.nextInt()));
    }
}
