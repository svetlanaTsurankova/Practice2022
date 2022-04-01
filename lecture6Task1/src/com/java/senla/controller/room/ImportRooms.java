package com.java.senla.controller.room;

import com.java.senla.utils.FilePaths;
import com.java.senla.model.service.ManagerHotel;
import com.java.senla.view.IAction;

public class ImportRooms implements IAction {

    @Override
    public void execute()  {
        System.out.print("Import rooms from CSV file  : ");
        ManagerHotel.managerHotel().importRoomCsvFile(FilePaths.ROOM_PATCH);
        ManagerHotel.managerHotel().showAllRooms();
    }
}
