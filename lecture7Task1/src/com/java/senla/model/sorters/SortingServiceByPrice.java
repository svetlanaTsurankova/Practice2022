package com.java.senla.model.sorters;

import com.java.senla.model.entity.Service;

import java.util.Comparator;

public class SortingServiceByPrice implements Comparator<Service> {
    public int compare(Service s1, Service s2) {
        if (s1 != null && s2 != null) {
            return Double.compare(s1.getPrice(), s2.getPrice());
        } else if (s1 != null) {
            return 1;
        } else {
            return -1;
        }
    }
}
