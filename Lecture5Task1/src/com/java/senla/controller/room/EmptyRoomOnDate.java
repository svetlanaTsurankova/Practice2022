package com.java.senla.controller.room;

import com.java.senla.model.service.ManagerHotel;
import com.java.senla.view.IAction;

import java.time.LocalDate;
import java.util.Scanner;

public class EmptyRoomOnDate implements IAction {
    ManagerHotel managerHotel = new ManagerHotel();
    Scanner scanner = new Scanner(System.in);

    @Override
    public void execute() {
        System.out.print("Input the in-date like \"YYYY-MM-DD\" ...");
        String dat = scanner.next();
        LocalDate inDate = LocalDate.parse(dat);
        managerHotel.showEmptyRoomOnDate(inDate);

    }
}
