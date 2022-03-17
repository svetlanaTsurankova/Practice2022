package com.java.senla.controller.lodger;

import com.java.senla.view.IAction;
import com.java.senla.model.service.ManagerHotel;
import com.java.senla.model.service.impl.ManagerLodger;
import com.java.senla.model.service.impl.ManagerRoom;

import java.util.Scanner;

public class ShowLastLodgersRoom implements IAction {
    @Override
    public void execute() {
        ManagerHotel managerHotel = new ManagerHotel();
        ManagerRoom managerRoom  = new ManagerRoom();
        ManagerLodger managerLodger = new ManagerLodger();
        managerRoom.getRooms();
        managerLodger.getLodgers();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input the room id ...");
        Integer number = scanner.nextInt();
        managerHotel.showLastLodgersRoom(managerRoom.getRoomByNumber(number));
    }
}
