package com.java.senla.controller.room;

import com.java.senla.model.service.ManagerHotel;
import com.java.senla.model.sorters.SortingRoomByPrice;
import com.java.senla.view.IAction;

public class SortingEmpRoomOnPrice implements IAction {

    @Override
    public void execute() {
        System.out.println("Sorting free room by price : ");
        ManagerHotel.managerHotel().sortFreeRoom(new SortingRoomByPrice().getSortingRoomByPrice());
        ManagerHotel.managerHotel().showAllFreeRooms();
    }
}
