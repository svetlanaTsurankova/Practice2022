package com.java.senla.controller.service;

import com.java.senla.utils.FilePaths;
import com.java.senla.model.service.ManagerHotel;
import com.java.senla.view.IAction;

import java.io.IOException;


public class ExportServices implements IAction {

    @Override
    public void execute() throws IOException {
        System.out.print("Export service CSV file  : ");
        ManagerHotel.managerHotel().exportServiceCsvFile(FilePaths.EXP_SERVICE_PATCH);
    }
}
