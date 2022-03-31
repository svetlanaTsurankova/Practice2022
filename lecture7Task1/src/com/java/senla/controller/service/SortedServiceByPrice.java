package com.java.senla.controller.service;

import com.java.senla.model.service.ManagerHotel;
import com.java.senla.view.IAction;

public class SortedServiceByPrice implements IAction {

    @Override
    public void execute() {
        ManagerHotel.managerHotel().sortedServiceByPrice();
    }
}
