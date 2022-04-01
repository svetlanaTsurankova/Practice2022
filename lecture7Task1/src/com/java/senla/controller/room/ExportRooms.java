package com.java.senla.controller.room;

import com.java.senla.model.service.ManagerHotel;
import com.java.senla.utils.FilePaths;
import com.java.senla.view.IAction;

import java.io.IOException;

public class ExportRooms implements IAction {

    @Override
    public void execute() throws IOException {
        System.out.print("Export rooms CSV file  : ");
        ManagerHotel.managerHotel().exportRoomCsvFile(FilePaths.EXP_ROOM_PATCH);
    }
}
