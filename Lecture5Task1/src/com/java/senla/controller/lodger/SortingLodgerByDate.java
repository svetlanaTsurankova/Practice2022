package com.java.senla.controller.lodger;

import com.java.senla.view.IAction;
import com.java.senla.model.service.ManagerHotel;
import com.java.senla.model.service.impl.ManagerLodger;
import com.java.senla.model.service.impl.ManagerRoom;
import com.java.senla.model.sorters.SortingLodgerDate;

public class SortingLodgerByDate implements IAction {
    @Override
    public void execute() {
        ManagerHotel managerHotel = new ManagerHotel();
        ManagerLodger managerLodger = new ManagerLodger();
        ManagerRoom managerRoom = new ManagerRoom();
        managerRoom.getRooms();
        managerLodger.getLodgers();
        managerHotel.sortLodger(new SortingLodgerDate().getSortingLodgerByDate());
    }
}
