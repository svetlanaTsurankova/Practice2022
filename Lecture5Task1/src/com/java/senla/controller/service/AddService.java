package com.java.senla.controller.service;

import com.java.senla.model.entity.Service;
import com.java.senla.view.IAction;
import com.java.senla.model.service.ManagerHotel;

import java.util.Scanner;

public class AddService implements IAction {
    @Override
    public void execute() {
        ManagerHotel managerHotel = new ManagerHotel();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input service id: ");
        int id = scanner.nextInt();
        System.out.print("Input service name: ");
        String name = scanner.nextLine();
        System.out.print("Input service price: ");
        double price = scanner.nextDouble();
        managerHotel.createService(new Service(id, name, price));
        System.out.printf("Name service: %s  price: %.2f \n", name, price);
    }
}
