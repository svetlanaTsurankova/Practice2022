package com.java.senla.model.sorters;

import com.java.senla.model.entity.Room;

import java.util.Comparator;

public class SortingRoomByCapacity implements Comparator<Room> {
    public int compare(Room room1, Room room2) {
        if (room1 != null && room2 != null) {
            return Integer.compare(room1.getCapacity(), room2.getCapacity());
        } else if (room1 == null && room2 == null) {
            return 1;
        } else {
            return 0;
        }
    }

    public Comparator<Room> getSortingRoomByCapacity() {
        SortingRoomByCapacity sortingRoomByCapacity = new SortingRoomByCapacity();
        return sortingRoomByCapacity;
    }
}
