package com.java.senla.controller.lodger;

import com.java.senla.model.service.ManagerHotel;
import com.java.senla.model.service.impl.ManagerLodger;
import com.java.senla.model.service.impl.ManagerService;
import com.java.senla.view.IAction;

import java.util.Scanner;

public class ServicesLodger implements IAction {
    ManagerLodger managerLodger = new ManagerLodger();
    ManagerService managerService = new ManagerService();
    Scanner scanner = new Scanner(System.in);

    @Override
    public void execute() {
        try {
            System.out.print("Input the lodger id 1..4 : ");
            Integer lodgerId = scanner.nextInt();
            System.out.print("Input service id 1..5 : ");
            Integer service = scanner.nextInt();
            ManagerHotel.managerHotel().addService(managerLodger.getLodgerById(lodgerId), managerService.getServiceById(service));
        } catch (
                Exception e) {
            System.err.println("Failed input Id Lodger or id service!");
        }
    }
}
