package com.java.senla.controller.room;

import com.java.senla.model.data.paths.FilePaths;
import com.java.senla.model.service.ManagerHotel;
import com.java.senla.view.IAction;

import java.io.IOException;

public class ExportRooms implements IAction {
    ManagerHotel managerHotel = new ManagerHotel();

    @Override
    public void execute() throws IOException {
        System.out.print("Export rooms CSV file  : ");
        managerHotel.exportRoomCsvFile(FilePaths.exproomPatch);
    }
}
