package com.java.senla.controller.room;

import com.java.senla.model.service.ManagerHotel;
import com.java.senla.model.sorters.SortingRoomByStars;
import com.java.senla.view.IAction;

public class SortingEmpRoomOnStars implements IAction {

    @Override
    public void execute() {
        System.out.println("Sorting free room by stars: ");
        ManagerHotel.managerHotel().sortFreeRoom(new SortingRoomByStars().getSortingRoomByStars());
        ManagerHotel.managerHotel().showAllFreeRooms();
    }
}
