package com.java.senla.controller.lodger;

import com.java.senla.model.service.ManagerHotel;
import com.java.senla.model.sorters.SortingLodgerDate;
import com.java.senla.view.IAction;

public class SortedLodgersByDate implements IAction {

    @Override
    public void execute() {
        ManagerHotel.managerHotel().sortLodger(new SortingLodgerDate().getSortingLodgerByDate());
        ManagerHotel.managerHotel().showAllLodger();
    }
}
