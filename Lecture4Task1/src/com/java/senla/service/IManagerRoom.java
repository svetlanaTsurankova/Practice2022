package com.java.senla.service;

import com.java.senla.entity.Room;

import java.util.Comparator;

public interface IManagerRoom {
    void addRoom(Room room);

  //  Room[] sortRoom(Comparator<Room> comparator);

    Room getRoomById(int room);
}
