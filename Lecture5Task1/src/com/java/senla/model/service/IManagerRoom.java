package com.java.senla.model.service;

import com.java.senla.model.entity.Room;

public interface IManagerRoom {
    void addRoom(Room room);

    int getCountFreeRooms();

    Room[] getFreeRooms();

    Room getRoomById(int roomId);
}
