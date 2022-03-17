package com.java.senla.controller.service;

import com.java.senla.model.service.ManagerHotel;
import com.java.senla.view.IAction;

public class SortedServiceByPrice implements IAction {
    ManagerHotel managerHotel = new ManagerHotel();

    @Override
    public void execute() {
        managerHotel.sortedServiceByPrice();
    }
}
