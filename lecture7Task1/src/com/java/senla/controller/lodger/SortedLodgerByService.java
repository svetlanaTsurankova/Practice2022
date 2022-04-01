package com.java.senla.controller.lodger;

import com.java.senla.model.service.ManagerHotel;
import com.java.senla.model.service.impl.ManagerLodger;
import com.java.senla.view.IAction;

import java.util.Scanner;

public class SortedLodgerByService implements IAction {
    ManagerLodger managerLodger = new ManagerLodger();
    Scanner scanner = new Scanner(System.in);

    @Override
    public void execute() {
        try {
            System.out.print("Input lodger id ...");
            ManagerHotel.managerHotel().sortLodgerService(managerLodger.getLodgerById(scanner.nextInt()));
        } catch (Exception e) {
            System.err.println("Failed to add id Lodger!");
        }
    }
}
