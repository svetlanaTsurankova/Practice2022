package com.java.senla.controller.room;

import com.java.senla.model.service.ManagerHotel;
import com.java.senla.model.sorters.SortingRoomByCapacity;
import com.java.senla.view.IAction;

public class SortingEmpRoomOnCapacity implements IAction {
    ManagerHotel managerHotel = new ManagerHotel();

    @Override
    public void execute() {
        System.out.print("Sorting free room by capacity : ");
        managerHotel.sortFreeRoom(new SortingRoomByCapacity().getSortingRoomByCapacity());
        managerHotel.showAllFreeRooms();

    }
}
