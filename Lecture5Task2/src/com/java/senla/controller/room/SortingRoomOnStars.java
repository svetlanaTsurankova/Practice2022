package com.java.senla.controller.room;

import com.java.senla.model.service.ManagerHotel;
import com.java.senla.model.sorters.SortingRoomByStars;
import com.java.senla.view.IAction;

public class SortingRoomOnStars implements IAction {
    ManagerHotel managerHotel = new ManagerHotel();

    @Override
    public void execute() {
        System.out.println("Sorting room by stars: ");
        managerHotel.sortRoom(new SortingRoomByStars().getSortingRoomByStars());
        managerHotel.showAllRooms();
    }
}
