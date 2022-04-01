package com.java.senla.model.sorters;

import com.java.senla.model.entity.Lodger;

import java.util.Comparator;

public class SortingLodger implements Comparator<Lodger> {
    public int compare(Lodger lodger1, Lodger lodger2) {
        if (lodger1 != null && lodger2 != null) {
            return lodger1.getFullName().compareTo(lodger2.getFullName());
        } else if (lodger1 != null) {
            return 1;
        } else {
            return -1;
        }
    }

    public Comparator<Lodger> getSortingLodger() {
        System.out.println("sorting Lodger by name ");
        return new SortingLodger();
    }
}
