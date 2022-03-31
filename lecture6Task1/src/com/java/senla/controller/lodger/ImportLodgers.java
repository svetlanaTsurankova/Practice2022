package com.java.senla.controller.lodger;

import com.java.senla.utils.FilePaths;
import com.java.senla.model.service.ManagerHotel;
import com.java.senla.view.IAction;

public class ImportLodgers implements IAction {

    @Override
    public void execute()  {
        System.out.print("Import lodgers from CSV file  : ");
        ManagerHotel.managerHotel().importLodgerCsvFile(FilePaths.LODGER_PATCH);
        ManagerHotel.managerHotel().showAllLodger();
    }
}
