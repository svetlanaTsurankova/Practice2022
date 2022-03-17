package com.java.senla.controller.room;

import com.java.senla.model.service.ManagerHotel;
import com.java.senla.model.sorters.SortingRoomByPrice;
import com.java.senla.view.IAction;

public class SortingRoomOnPrice implements IAction {
    ManagerHotel managerHotel = new ManagerHotel();

    @Override
    public void execute() {
        System.out.print("Sorting room by price: ");
        managerHotel.sortRoom(new SortingRoomByPrice().getSortingRoomByPrice());
        managerHotel.showAllRooms();
    }
}
