package com.java.senla.controller.service;

import com.java.senla.view.IAction;
import com.java.senla.model.service.ManagerHotel;
import com.java.senla.model.service.impl.ManagerService;

import java.util.Scanner;

public class ChangeServicePrice implements IAction {
    @Override
    public void execute() {
        ManagerHotel managerHotel = new ManagerHotel();
        ManagerService managerService = new ManagerService();
        Scanner scanner = new Scanner(System.in);
        managerService.getServices();
        managerHotel.showAllServices();
        System.out.print("Input service name: ");
        Integer id = scanner.nextInt();
        System.out.print("Input service price: ");
        double price = scanner.nextDouble();
        managerHotel.changePriceService(managerService.getServiceById(id), price);
    }
}
