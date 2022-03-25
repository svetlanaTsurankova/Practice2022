package com.java.senla.controller.lodger;

import com.java.senla.model.service.ManagerHotel;
import com.java.senla.model.service.impl.ManagerLodger;
import com.java.senla.model.service.impl.ManagerRoom;
import com.java.senla.view.IAction;

import java.util.Scanner;

public class CheckOutRoom implements IAction {
    Scanner scanner = new Scanner(System.in);
    ManagerHotel managerHotel = new ManagerHotel();
    ManagerLodger managerLodger = new ManagerLodger();
    ManagerRoom managerRoom = new ManagerRoom();

    @Override
    public void execute() {
        System.out.print("Input the lodger id to check-out...");
        Integer lodgerId = scanner.nextInt();
        System.out.print("Input the number Room...");
        Integer room = scanner.nextInt();
        managerHotel.checkOut(managerLodger.getLodgerById(lodgerId), managerRoom.getRoomByNumber(room));
    }
}