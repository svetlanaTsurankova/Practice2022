package com.java.senla.controller.room;

import com.java.senla.model.service.ManagerHotel;
import com.java.senla.model.service.impl.ManagerRoom;
import com.java.senla.view.IAction;
import com.java.senla.model.sorters.SortingRoomByCapacity;

public class SortingEmpRoomOnCapacity implements IAction {
    @Override
    public void execute() {
        ManagerHotel managerHotel = new ManagerHotel();
        System.out.print("Sorting free room by capacity : ");
        managerHotel.sortFreeRoom(new SortingRoomByCapacity().getSortingRoomByCapacity());
        managerHotel.showAllFreeRooms();

    }
}
