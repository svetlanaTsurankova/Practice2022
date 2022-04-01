package com.java.senla.model.service.impl;

import com.java.senla.model.entity.Room;
import com.java.senla.model.entity.StatusRoomEnum;
import com.java.senla.model.service.IManagerRoom;
import com.java.senla.utils.readers.ImportCSVFile;
import com.java.senla.utils.writers.ExportToCSVFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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


    public void importRoomByCsv(String file) {
        ImportCSVFile importCSVFile = new ImportCSVFile();
        List<Room> room = new ArrayList<>();
        ArrayList<Object> list = importCSVFile.importFile(file);
        if (list != null)
            for (Object o : list) {
                room.add(parseString((List<Room>) o));
                rooms = room.stream().map(old -> rooms.stream()
                                .filter(update -> old.getId() == update.getId() &&
                                        old.getNumberRoom() == update.getNumberRoom() &&
                                        old.getPrice() == update.getPrice() &&
                                        old.getCapacity() == update.getCapacity() &&
                                        old.getStatus() == update.getStatus() &&
                                        old.getStarsRoom() == update.getStarsRoom())
                                .findFirst()
                                .orElse(old))
                        .collect(Collectors.toList());
            }
    }

    public Room parseString(List<Room> listparse) {
        Room newRoom = new Room();
        if (listparse != null) {
            for (int i = 0; i < listparse.size(); i++) {
                newRoom.setId(Integer.parseInt(String.valueOf(listparse.get(0))));
                newRoom.setNumberRoom(Integer.parseInt(String.valueOf(listparse.get(1))));
                newRoom.setPrice(Double.parseDouble(String.valueOf(listparse.get(2))));
                newRoom.setCapacity(Integer.parseInt(String.valueOf(listparse.get(3))));
                newRoom.setStatus(StatusRoomEnum.valueOf(String.valueOf(listparse.get(4))));
                newRoom.setStarsRoom(Integer.parseInt(String.valueOf(listparse.get(5))));
            }
        }
        return newRoom;
    }

    public void exportRoomCsvFile(String file) {
        ExportToCSVFile exportToCSVFile = new ExportToCSVFile();
        try {
            if (rooms != null) {
                List<Object> room = new ArrayList<>(rooms);
                exportToCSVFile.writerToCSVFile(file, room);
            } else {
                System.out.println("List of services is empty");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Export OK");
    }
}