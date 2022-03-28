package com.java.senla.controller.service;

import com.java.senla.model.data.paths.FilePaths;
import com.java.senla.model.service.ManagerHotel;
import com.java.senla.view.IAction;

import java.io.IOException;


public class ExportServices implements IAction {
    ManagerHotel managerHotel = new ManagerHotel();

    @Override
    public void execute() throws IOException {
        System.out.print("Export service CSV file  : ");
        managerHotel.exportServiceCsvFile(FilePaths.EXP_SERVICE_PATCH);
    }
}
