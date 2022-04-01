package com.java.senla.controller.lodger;

import com.java.senla.model.service.ManagerHotel;
import com.java.senla.model.service.impl.ManagerLodger;
import com.java.senla.model.service.impl.ManagerRoom;
import com.java.senla.view.IAction;

import java.time.LocalDate;
import java.util.Scanner;

public class CheckInRoom implements IAction {
    ManagerLodger managerLodger = new ManagerLodger();
    ManagerRoom managerRoom = new ManagerRoom();
    Scanner scanner = new Scanner(System.in);

    @Override
    public void execute() {
        try {
            System.out.print("Input the Lodger id to check-in...");
            Integer lodgerId = scanner.nextInt();
            System.out.print("Input the number Room...");
            Integer number = scanner.nextInt();
            System.out.print("Input the in-date like \"YYYY-MM-DD\" ...");
            String dat = scanner.next();
            LocalDate inDate = LocalDate.parse(dat);
            System.out.print("Input the out-date like \"YYYY-MM-DD\"...");
            String dat1 = scanner.next();
            LocalDate outDate = LocalDate.parse(dat1);
            ManagerHotel.managerHotel().checkIn(managerLodger.getLodgerById(lodgerId), managerRoom.getRoomByNumber(number), inDate, outDate);
        } catch (Exception e) {
            System.err.println("Failed to add parameters!");
        }
    }
}