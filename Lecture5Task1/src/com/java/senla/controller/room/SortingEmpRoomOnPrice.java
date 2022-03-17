package com.java.senla.controller.room;

import com.java.senla.model.service.ManagerHotel;
import com.java.senla.model.sorters.SortingRoomByPrice;
import com.java.senla.view.IAction;

public class SortingEmpRoomOnPrice implements IAction {
    ManagerHotel managerHotel = new ManagerHotel();

    @Override
    public void execute() {
        System.out.print("Sorting free room by price : ");
        managerHotel.sortFreeRoom(new SortingRoomByPrice().getSortingRoomByPrice());
        managerHotel.showAllFreeRooms();
    }
}
