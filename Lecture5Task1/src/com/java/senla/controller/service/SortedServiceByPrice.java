package com.java.senla.controller.service;

import com.java.senla.view.IAction;
import com.java.senla.model.service.ManagerHotel;

public class SortedServiceByPrice implements IAction {
    @Override
    public void execute() {
        ManagerHotel managerHotel = new ManagerHotel();
        managerHotel.sortedServiceByPrice();
    }
}
