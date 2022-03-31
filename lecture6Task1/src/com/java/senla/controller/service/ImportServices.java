package com.java.senla.controller.service;

import com.java.senla.utils.FilePaths;
import com.java.senla.model.service.ManagerHotel;
import com.java.senla.view.IAction;

public class ImportServices implements IAction {

    @Override
    public void execute() {
        System.out.println("Import service from CSV file  : ");
        ManagerHotel.managerHotel().importServiceCsvFile(FilePaths.SERVICE_PATCH);
        ManagerHotel.managerHotel().showAllServices();
    }
}
