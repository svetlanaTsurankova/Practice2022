package com.java.senla.controller.lodger;

import com.java.senla.view.IAction;
import com.java.senla.model.service.ManagerHotel;
import com.java.senla.model.service.impl.ManagerLodger;

public class TotalNumberOfLodgers implements IAction {
    @Override
    public void execute() {
        ManagerHotel managerHotel = new ManagerHotel();
        ManagerLodger managerLodger = new ManagerLodger();
        managerLodger.getLodgers();
        managerHotel.countLodger();
    }
}
