package com.java.senla.controller.lodger;

import com.java.senla.model.service.ManagerHotel;
import com.java.senla.view.IAction;

public class TotalNumberOfLodgers implements IAction {
    ManagerHotel managerHotel = new ManagerHotel();

    @Override
    public void execute() {
        managerHotel.countLodger();
    }
}
