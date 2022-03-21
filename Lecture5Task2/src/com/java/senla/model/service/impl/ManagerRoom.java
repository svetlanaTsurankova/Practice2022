package com.java.senla.model.service.impl;

import com.java.senla.model.entity.Room;
import com.java.senla.model.entity.StatusRoomEnum;
import com.java.senla.model.service.IManagerRoom;

import java.util.ArrayList;
import java.util.List;

public class ManagerRoom implements IManagerRoom {

    private int allRoom = 0;
    private List<Room> rooms ;

    public ManagerRoom() {
        rooms = new ArrayList<>();
        rooms.add(new Room(1, 100, 105.8, 1, StatusRoomEnum.RENOVATE, 2));
        rooms.add(new Room(2, 102, 205.8, 1, StatusRoomEnum.SERVICED, 3));
        rooms.add(new Room(3, 103, 305.8, 2, StatusRoomEnum.RENOVATE, 2));
        rooms.add(new Room(4, 104, 405.8, 3, StatusRoomEnum.SERVICED, 3));
        rooms.add(new Room(5, 105, 505.8, 2, StatusRoomEnum.SERVICED, 5));
        rooms.add(new Room(6, 106, 105.8, 1, StatusRoomEnum.RENOVATE, 2));
        rooms.add(new Room(7, 107, 205.8, 1, StatusRoomEnum.SERVICED, 3));
        rooms.add(new Room(8, 108, 305.8, 2, StatusRoomEnum.RENOVATE, 2));
        rooms.add(new Room(9, 109, 405.8, 4, StatusRoomEnum.SERVICED, 3));
        rooms.add(new Room(10, 110, 505.8, 2, StatusRoomEnum.SERVICED, 5));
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
}
