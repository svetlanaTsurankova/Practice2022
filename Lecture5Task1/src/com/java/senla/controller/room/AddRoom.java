package com.java.senla.controller.room;

import com.java.senla.model.entity.Room;
import com.java.senla.model.entity.StatusRoomEnum;
import com.java.senla.model.service.ManagerHotel;
import com.java.senla.view.IAction;

import java.util.Scanner;

public class AddRoom implements IAction {
    ManagerHotel managerHotel = new ManagerHotel();
    Scanner scanner = new Scanner(System.in);

    @Override
    public void execute() {
        System.out.print("input number room : ");
        int number = scanner.nextInt();
        System.out.print("input stars room : ");
        int stars = scanner.nextInt();
        System.out.print("input price room : ");
        double price = scanner.nextDouble();
        System.out.print("input capacity room: ");
        int capacity = scanner.nextInt();
        managerHotel.createRoom(new Room(11, number, price, capacity, StatusRoomEnum.SERVICED, stars, null));
        System.out.printf("New room : numberRoom %s , price : %.2f , capacity %s ,stars %s \n",
                11, price, capacity, stars);
    }
}
