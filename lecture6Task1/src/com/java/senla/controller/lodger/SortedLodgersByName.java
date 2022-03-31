package com.java.senla.controller.lodger;

import com.java.senla.model.service.ManagerHotel;
import com.java.senla.model.sorters.SortingLodger;
import com.java.senla.view.IAction;

public class SortedLodgersByName implements IAction {

    @Override
    public void execute() {
        ManagerHotel.managerHotel().sortLodger(new SortingLodger().getSortingLodger());
        ManagerHotel.managerHotel().showAllLodger();
    }
}
