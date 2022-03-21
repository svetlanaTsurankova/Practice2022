package com.java.senla.controller.lodger;

import com.java.senla.model.service.ManagerHotel;
import com.java.senla.model.sorters.SortingLodger;
import com.java.senla.view.IAction;

public class SortedLodgersByName implements IAction {
    ManagerHotel managerHotel = new ManagerHotel();

    @Override
    public void execute() {
        managerHotel.sortLodger(new SortingLodger().getSortingLodger());
        managerHotel.showAllLodger();
    }
}
