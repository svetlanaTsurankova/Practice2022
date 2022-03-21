package com.java.senla.controller.lodger;

import com.java.senla.model.service.ManagerHotel;
import com.java.senla.model.service.impl.ManagerLodger;
import com.java.senla.view.IAction;

import java.util.Scanner;

public class BillLodger implements IAction {
    ManagerHotel managerHotel = new ManagerHotel();
    ManagerLodger managerLodger = new ManagerLodger();
    Scanner scanner = new Scanner(System.in);

    @Override
    public void execute() {
        System.out.print("Input lodger id ...");
        managerHotel.billRoom(managerLodger.getLodgerById(scanner.nextInt()));
    }
}
