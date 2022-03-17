package com.java.senla.service;

import com.java.senla.entity.Room;

public class ManagerRoom {
    private int allRoom = 0;
    private Room[] rooms = new Room[10];

    public Room[] getRooms() {
        return rooms;
    }

    public void addRoom(Room room) {
        rooms[allRoom] = room;
        allRoom++;
        StringBuilder s = new StringBuilder();
        s.append(room);
    }
}
