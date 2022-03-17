package com.java.senla.controller.lodger;

import com.java.senla.model.entity.Lodger;
import com.java.senla.model.service.ManagerHotel;
import com.java.senla.view.IAction;

import java.util.Scanner;

public class AddLodger implements IAction {
    ManagerHotel managerHotel = new ManagerHotel();
    Scanner scanner = new Scanner(System.in);

    @Override
    public void execute() {
        System.out.print("Input lodger name ...");
        String name = scanner.next();
        managerHotel.receiveLodger(new Lodger(name));
    }
}