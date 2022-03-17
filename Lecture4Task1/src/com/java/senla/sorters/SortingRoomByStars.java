package com.java.senla.sorters;

import com.java.senla.entity.Room;

import java.util.Comparator;

public class SortingRoomByStars implements Comparator<Room> {
    public int compare(Room room1, Room room2) {
        if (room1 != null && room2 != null) {
            return Integer.compare(room1.getStarsRoom(), room2.getStarsRoom());
        } else if (room1 == null && room2 == null) {
            return 1;
        } else {
            return 0;
        }
    }

    public Comparator<Room> getSortingRoomByStars() {
        SortingRoomByStars sortingRoomByStars = new SortingRoomByStars();
        return sortingRoomByStars;
    }
}
