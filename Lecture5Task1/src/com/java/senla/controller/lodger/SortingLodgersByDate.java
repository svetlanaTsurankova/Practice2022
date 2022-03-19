package com.java.senla.controller.lodger;

import com.java.senla.model.service.ManagerHotel;
import com.java.senla.model.sorters.SortingLodgerDate;
import com.java.senla.view.IAction;

public class SortingLodgersByDate implements IAction {
    ManagerHotel managerHotel = new ManagerHotel();

    @Override
    public void execute() {
        managerHotel.sortLodger(new SortingLodgerDate().getSortingLodgerByDate());
        managerHotel.showAllLodger();
    }
}
