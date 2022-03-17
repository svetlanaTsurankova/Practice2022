package com.java.senla.controller.lodger;

import com.java.senla.view.IAction;
import com.java.senla.model.service.ManagerHotel;
import com.java.senla.model.service.impl.ManagerLodger;

import java.util.Scanner;

public class BillLodger implements IAction {
    @Override
    public void execute() {
        ManagerHotel managerHotel = new ManagerHotel();
        ManagerLodger managerLodger = new ManagerLodger();
        managerLodger.getLodgers();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input the lodger id ...");
        Integer id = scanner.nextInt();
        managerHotel.billRoom(managerLodger.getLodgerById(id));
    }
}
