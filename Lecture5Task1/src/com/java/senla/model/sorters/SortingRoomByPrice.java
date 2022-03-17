package com.java.senla.model.sorters;

import com.java.senla.model.entity.Room;

import java.util.Comparator;

public class SortingRoomByPrice implements Comparator<Room> {
    public int compare(Room room1, Room room2) {
        if (room1 != null && room2 != null) {
            return Double.compare(room1.getPrice(), room2.getPrice());
        } else if (room1 == null && room2 == null) {
            return 1;
        } else {
            return 0;
        }
    }
    public Comparator<Room> getSortingRoomByPrice(){
        SortingRoomByPrice sortingRoomByPrice = new SortingRoomByPrice();
        return sortingRoomByPrice;
    }
}
