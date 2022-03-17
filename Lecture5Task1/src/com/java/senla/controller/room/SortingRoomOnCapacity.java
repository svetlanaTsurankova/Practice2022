package com.java.senla.controller.room;

import com.java.senla.view.IAction;
import com.java.senla.model.service.ManagerHotel;
import com.java.senla.model.service.impl.ManagerRoom;
import com.java.senla.model.sorters.SortingRoomByCapacity;

public class SortingRoomOnCapacity implements IAction {
    @Override
    public void execute() {
        ManagerHotel managerHotel = new ManagerHotel();
        System.out.print("Sorting room by capacity: ");
        managerHotel.sortRoom(new SortingRoomByCapacity().getSortingRoomByCapacity());
        managerHotel.showAllRooms();
    }
}
