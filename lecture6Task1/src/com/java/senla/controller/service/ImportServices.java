package com.java.senla.controller.service;

import com.java.senla.model.data.paths.FilePaths;
import com.java.senla.model.service.ManagerHotel;
import com.java.senla.view.IAction;

public class ImportServices implements IAction {
    ManagerHotel managerHotel = new ManagerHotel();

    @Override
    public void execute() {
        System.out.print("Import service from CSV file  : ");
        managerHotel.importServiceCsvFile(FilePaths.servicePatch);
        managerHotel.showAllServices();
    }
}
