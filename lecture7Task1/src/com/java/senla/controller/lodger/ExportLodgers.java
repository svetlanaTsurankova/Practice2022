package com.java.senla.controller.lodger;

import com.java.senla.model.service.ManagerHotel;
import com.java.senla.utils.FilePaths;
import com.java.senla.view.IAction;

import java.io.IOException;

public class ExportLodgers implements IAction {

    @Override
    public void execute() throws IOException {

        ManagerHotel.managerHotel().exportLodgerCsvFile(FilePaths.EXP_LODGER_PATCH);
    }
}
