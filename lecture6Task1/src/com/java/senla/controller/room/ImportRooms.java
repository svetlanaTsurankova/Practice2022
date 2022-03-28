package com.java.senla.controller.room;

import com.java.senla.model.data.paths.FilePaths;
import com.java.senla.model.service.ManagerHotel;
import com.java.senla.view.IAction;

public class ImportRooms implements IAction {
    ManagerHotel managerHotel = new ManagerHotel();
    @Override
    public void execute()  {
        System.out.print("Import rooms from CSV file  : ");
        managerHotel.importRoomCsvFile(FilePaths.ROOM_PATCH);
        managerHotel.showAllRooms();
    }
}
