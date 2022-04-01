package com.java.senla.controller.room;

import com.java.senla.model.service.ManagerHotel;
import com.java.senla.view.IAction;

public class CountEmptyRooms implements IAction {

    @Override
    public void execute() {
        ManagerHotel.managerHotel().countFreeRooms();

    }
}
