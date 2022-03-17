package com.java.senla.controller.room;

import com.java.senla.model.service.ManagerHotel;
import com.java.senla.model.sorters.SortingRoomByCapacity;
import com.java.senla.view.IAction;

public class SortingRoomOnCapacity implements IAction {
    ManagerHotel managerHotel = new ManagerHotel();

    @Override
    public void execute() {
        System.out.print("Sorting room by capacity: ");
        managerHotel.sortRoom(new SortingRoomByCapacity().getSortingRoomByCapacity());
        managerHotel.showAllRooms();
    }
}
