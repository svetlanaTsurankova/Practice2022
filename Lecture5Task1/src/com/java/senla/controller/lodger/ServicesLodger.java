package com.java.senla.controller.lodger;

import com.java.senla.view.IAction;
import com.java.senla.model.service.impl.ManagerLodger;
import com.java.senla.model.service.impl.ManagerService;

import java.util.Scanner;

public class ServicesLodger implements IAction {
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        ManagerLodger managerLodger = new ManagerLodger();
        ManagerService managerService = new ManagerService();
        managerLodger.getLodgers();
        managerService.getServices();
        System.out.print("Input the lodger id 1..4 : ");
        Integer lodgerId = scanner.nextInt();
        System.out.print("Input service id 1..5 : ");
        Integer service = scanner.nextInt();
        managerLodger.addServiceToLodger(managerLodger.getLodgerById(lodgerId), managerService.getServiceById(service));

    }
}
