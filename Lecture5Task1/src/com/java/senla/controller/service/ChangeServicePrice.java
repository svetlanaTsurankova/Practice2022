package com.java.senla.controller.service;

import com.java.senla.model.service.ManagerHotel;
import com.java.senla.model.service.impl.ManagerService;
import com.java.senla.view.IAction;

import java.util.Scanner;

public class ChangeServicePrice implements IAction {
    ManagerHotel managerHotel = new ManagerHotel();
    ManagerService managerService = new ManagerService();
    Scanner scanner = new Scanner(System.in);

    @Override
    public void execute() {
        System.out.print("Input id service : ");
        int id = scanner.nextInt();
        System.out.print("Input service price : ");
        double price = scanner.nextDouble();
        managerHotel.changePriceService(managerService.getServiceById(id), price);
    }
}
