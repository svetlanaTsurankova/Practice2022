package com.java.senla.controller.room;

import com.java.senla.model.service.ManagerHotel;
import com.java.senla.model.sorters.SortingRoomByCapacity;
import com.java.senla.view.IAction;

public class SortingEmpRoomOnCapacity implements IAction {


    @Override
    public void execute() {
        System.out.println("Sorting free room by capacity : ");
        ManagerHotel.managerHotel().sortFreeRoom(new SortingRoomByCapacity().getSortingRoomByCapacity());
        ManagerHotel.managerHotel().showAllFreeRooms();
    }
}
