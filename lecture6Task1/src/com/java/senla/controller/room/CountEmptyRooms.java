package com.java.senla.controller.room;

import com.java.senla.model.service.ManagerHotel;
import com.java.senla.view.IAction;

public class CountEmptyRooms implements IAction {
    ManagerHotel managerHotel = new ManagerHotel();

    @Override
    public void execute() {
        managerHotel.countFreeRooms();

    }
}
