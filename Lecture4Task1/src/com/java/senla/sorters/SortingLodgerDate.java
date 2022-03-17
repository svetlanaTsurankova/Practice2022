package com.java.senla.sorters;

import com.java.senla.entity.Lodger;

import java.util.Comparator;

public class SortingLodgerDate implements Comparator<Lodger> {
    public int compare(Lodger lodger1, Lodger lodger2) {
        if (lodger1 != null && lodger2 != null) {
            return lodger1.getDateCheckOut().compareTo(lodger2.getDateCheckOut());
        } else if (lodger1 != null) {
            return 1;
        } else {
            return -1;
        }
    }

    public Comparator<Lodger> getSortingLodgerByDate() {
        SortingLodgerDate sortingLodgerDate = new SortingLodgerDate();
        System.out.println("sorting Lodger by date ");
        return sortingLodgerDate;
    }
}
