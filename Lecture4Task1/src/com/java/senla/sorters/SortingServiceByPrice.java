package com.java.senla.sorters;

import com.java.senla.entity.Service;

import java.util.Comparator;

public class SortingServiceByPrice implements Comparator<Service> {
    public int compare(Service s1, Service s2) {
        if (s1 != null && s2 != null) {
            return Double.compare(s1.getPrice(), s2.getPrice());
        } else if (s1 != null && s2 == null) {
            return 1;
        } else {
            return -1;
        }
    }
}
