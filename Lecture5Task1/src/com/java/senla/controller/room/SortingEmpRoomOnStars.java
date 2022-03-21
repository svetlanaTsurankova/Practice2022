package com.java.senla.controller.room;

import com.java.senla.model.service.ManagerHotel;
import com.java.senla.model.sorters.SortingRoomByStars;
import com.java.senla.view.IAction;

public class SortingEmpRoomOnStars implements IAction {
    ManagerHotel managerHotel = new ManagerHotel();

    @Override
    public void execute() {
        System.out.print("Sorting free room by stars: ");
        managerHotel.sortFreeRoom(new SortingRoomByStars().getSortingRoomByStars());
        managerHotel.showAllFreeRooms();
    }
}
