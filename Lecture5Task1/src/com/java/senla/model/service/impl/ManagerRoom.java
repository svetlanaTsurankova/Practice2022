package com.java.senla.model.service.impl;

import com.java.senla.model.entity.Lodger;
import com.java.senla.model.entity.Room;
import com.java.senla.model.entity.StatusRoomEnum;
import com.java.senla.model.service.IManagerRoom;

public class ManagerRoom implements IManagerRoom {

    private int allRoom = 0;
    private Room[] rooms = new Room[10];

    public ManagerRoom() {
        rooms = new Room[]{
                rooms[0] = new Room(1, 100, 105.8, 1, StatusRoomEnum.RENOVATE, 2, null),
                rooms[1] = new Room(2, 102, 205.8, 1, StatusRoomEnum.OCCUPIED, 3, new Lodger[2]),
                rooms[2] = new Room(3, 103, 305.8, 2, StatusRoomEnum.RENOVATE, 2, null),
                rooms[3] = new Room(4, 104, 405.8, 3, StatusRoomEnum.SERVICED, 3, null),
                rooms[4] = new Room(5, 105, 505.8, 2, StatusRoomEnum.OCCUPIED, 5, new Lodger[1]),
                rooms[5] = new Room(6, 106, 105.8, 1, StatusRoomEnum.RENOVATE, 2, null),
                rooms[6] = new Room(7, 107, 205.8, 1, StatusRoomEnum.OCCUPIED, 3, new Lodger[3]),
                rooms[7] = new Room(8, 108, 305.8, 2, StatusRoomEnum.RENOVATE, 2, null),
                rooms[8] = new Room(9, 109, 405.8, 4, StatusRoomEnum.SERVICED, 3, null),
                rooms[9] = new Room(10, 110, 505.8, 2, StatusRoomEnum.OCCUPIED, 5, new Lodger[0]),
        };
    }

    public Room[] getRooms() {
        return rooms;
    }

    public void setRooms(Room[] rooms) {
        this.getRooms();
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
        rooms[allRoom] = room;
        allRoom++;
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

    public Room[] getFreeRooms() {
        Room[] freeRooms = new Room[getCountFreeRooms()];
        int j = 0;
        for (Room room : rooms) {
            if (room.getStatus().equals(StatusRoomEnum.SERVICED) || room.getStatus().equals(StatusRoomEnum.RENOVATE)) {
                freeRooms[j] = room;
                j++;
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
