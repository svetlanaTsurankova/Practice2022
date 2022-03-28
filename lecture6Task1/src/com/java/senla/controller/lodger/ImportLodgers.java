package com.java.senla.controller.lodger;

import com.java.senla.model.data.paths.FilePaths;
import com.java.senla.model.service.ManagerHotel;
import com.java.senla.view.IAction;

public class ImportLodgers implements IAction {
    ManagerHotel managerHotel = new ManagerHotel();
    @Override
    public void execute()  {
        System.out.print("Import lodgers from CSV file  : ");
        managerHotel.importLodgerCsvFile(FilePaths.LODGER_PATCH);
        managerHotel.showAllLodger();
    }
}
