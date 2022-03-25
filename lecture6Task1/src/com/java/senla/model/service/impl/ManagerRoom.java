package com.java.senla.model.service.impl;

import com.java.senla.model.data.readers.ImportCSVFile;
import com.java.senla.model.entity.Room;
import com.java.senla.model.entity.Service;
import com.java.senla.model.entity.StatusRoomEnum;
import com.java.senla.model.service.IManagerRoom;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ManagerRoom implements IManagerRoom {

    private int allRoom = 0;
    private List<Room> rooms = new ArrayList<Room>();

    public ManagerRoom() {
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public Room getRoomByNumber(Integer number) {
        for (Room room : rooms) {
            if (room.getNumberRoom() == number) {
                return room;
            }
        }
        return null;
    }

    public void addRoom(Room room) {
        if (room != null) {
            rooms.add(room);
            allRoom++;
        }
    }

    public int getCountFreeRooms() {
        int count = 0;
        for (Room value : rooms) {
            if (value.getStatus().equals(StatusRoomEnum.SERVICED) || value.getStatus().equals(StatusRoomEnum.RENOVATE)) {
                count++;
            }
        }
        return count;
    }

    public List<Room> getFreeRooms() {
        List<Room> freeRooms = new ArrayList<>(getCountFreeRooms());
        for (Room room : rooms) {
            if (room.getStatus().equals(StatusRoomEnum.SERVICED) || room.getStatus().equals(StatusRoomEnum.RENOVATE)) {
                freeRooms.add(room);
            }
        }
        return freeRooms;
    }

    public Room getRoomById(int roomId) {
        for (Room room : rooms) {
            if (room.getId() == roomId) {
                return room;
            }
        }
        return null;
    }

    public List<Room> importRoomCsv(String file) {

        ImportCSVFile importCSVFile = new ImportCSVFile();
        importCSVFile.importFile(file);
        List<String[]> list = importCSVFile.getNewList();
        if (list != null) {
            for (String[] arr : list) {
                Room newRoom = new Room();
                newRoom.setId(Integer.parseInt(arr[0]));
                newRoom.setNumberRoom(Integer.parseInt(arr[1]));
                newRoom.setPrice(Double.parseDouble(arr[2]));
                newRoom.setCapacity(Integer.parseInt(arr[3]));
                newRoom.setStatus(StatusRoomEnum.valueOf(arr[4]));
                newRoom.setStarsRoom(Integer.parseInt(arr[5]));
                rooms.add(newRoom);
            }
        }
        return rooms;
    }
    public void exportRoomCsvFile(String file) throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter(file);
        List<Room> arr = rooms;
        for (Room room : arr) {
            printWriter.println(room);
        }
        printWriter.close();
        System.out.println("Export OK");
    }
}