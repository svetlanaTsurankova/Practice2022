package com.java.senla.controller.room;

import com.java.senla.model.service.ManagerHotel;
import com.java.senla.model.sorters.SortingRoomByCapacity;
import com.java.senla.view.IAction;

public class SortingRoomOnCapacity implements IAction {

    @Override
    public void execute() {
        System.out.println("Sorting room by capacity: ");
        ManagerHotel.managerHotel().sortRoom(new SortingRoomByCapacity().getSortingRoomByCapacity());
        ManagerHotel.managerHotel().showAllRooms();
    }
}
