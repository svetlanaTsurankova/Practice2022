package com.java.senla.model.service;

import com.java.senla.model.entity.Room;

public interface IManagerRoom {
    void addRoom(Room room);

    int getCountFreeRooms();

    Room getRoomById(int roomId);
}
