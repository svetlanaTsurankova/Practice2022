package com.java.senla.controller.room;

import com.java.senla.model.service.ManagerHotel;
import com.java.senla.model.sorters.SortingRoomByPrice;
import com.java.senla.view.IAction;

public class SortingRoomOnPrice implements IAction {

    @Override
    public void execute() {
        System.out.println("Sorting room by price: ");
        ManagerHotel.managerHotel().sortRoom(new SortingRoomByPrice().getSortingRoomByPrice());
        ManagerHotel.managerHotel().showAllRooms();
    }
}
