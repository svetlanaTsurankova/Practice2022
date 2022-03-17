package com.java.senla.service.impl;
import com.java.senla.entity.Room;
import com.java.senla.service.IManagerRoom;

public class ManagerRoom implements IManagerRoom {
    private int allRoom = 0;
    private Room[] rooms = new Room[10];

    public Room[] getRooms() {
        return rooms;
    }

    public void addRoom(Room room) {
        rooms[allRoom] = room;
        allRoom++;
    }
public int getCountFreeRooms() {
    int count = 0;
    for (Room value : rooms) {
        if (value.getStatus().equals("SERVICED") || value.getStatus().equals("RENOVATE")) {
            count++;
        }
    }
    return count;
}

    public Room[] getFreeRooms() {
        Room[] freeRooms = new Room[getCountFreeRooms()];
        int j =0;
        for (Room room : rooms) {
            if (room.getStatus().equals("SERVICED") || room.getStatus().equals("RENOVATE")) {
                freeRooms[j] = room;
                j++;
            }
        }
        return freeRooms;
    }

    public Room getRoomById(int roomId) {
        Room[] rooms = this.rooms;
        for (Room room : rooms) {
            if (room.getId() == roomId) {
                return room;
            }
        }
        return null;
    }
}
