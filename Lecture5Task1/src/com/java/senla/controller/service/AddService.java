package com.java.senla.controller.service;

import com.java.senla.model.entity.Service;
import com.java.senla.model.service.ManagerHotel;
import com.java.senla.view.IAction;

import java.util.Scanner;

public class AddService implements IAction {
    ManagerHotel managerHotel = new ManagerHotel();
    Scanner scanner = new Scanner(System.in);

    @Override
    public void execute() {
        System.out.print("Input service id: ");
        int id = scanner.nextInt();
        System.out.print("Input service price: ");
        double price = scanner.nextDouble();
        System.out.print("Input service name: ");
        String name = scanner.next();
        managerHotel.createService(new Service(id, name, price));
        System.out.printf("Name service: %s  price: %.2f \n", name, price);
    }
}
