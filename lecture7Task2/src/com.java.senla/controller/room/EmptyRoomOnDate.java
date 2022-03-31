package com.java.senla.controller.room;

import com.java.senla.model.service.ManagerHotel;
import com.java.senla.view.IAction;

import java.time.LocalDate;
import java.util.Scanner;

public class EmptyRoomOnDate implements IAction {
    Scanner scanner = new Scanner(System.in);

    @Override
    public void execute() {
        System.out.print("Input the in-date like \"YYYY-MM-DD\" ...");
        LocalDate inDate = LocalDate.parse(scanner.next());
        ManagerHotel.managerHotel().showEmptyRoomOnDate(inDate);

    }
}
