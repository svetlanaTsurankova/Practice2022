package com.java.senla.service.impl;

import com.java.senla.entity.Lodger;
import com.java.senla.entity.Service;
import com.java.senla.service.IManagerLodger;

import java.util.Arrays;
import java.util.Comparator;

public class ManagerLodger implements IManagerLodger {
    private Lodger[] lodgers = new Lodger[4];
    private int allLodger = 0;

    public Lodger[] getLodgers() {
        return lodgers;
    }


    public void addLodger(Lodger lodger) {
        lodgers[allLodger] = lodger;
        allLodger++;
    }

    public Service[] getLodgerService(Lodger lodger) {
        return lodger.getServices();
    }

    public int getCountLodgerService(Lodger lodger) {
        int count = 0;
        for (int i = 0; i < getLodgerService(lodger).length; i++) {
            if (lodger.getServices()[i] != null) {
                count++;
            }
        }
        return count;
    }

    public void addServiceToLodger(Lodger lodger, Service service) {
        int i = getCountLodgerService(lodger);
        lodger.getServices()[i] = service;
        System.out.println("Lodger add service: " + lodger.getServices()[i].getServiceName());
    }

    public Service[] sortLodgesServiceByPrice(Lodger lodger, Comparator<Service> comparator) {
        Service[] sortedLodgerService = getLodgerService(lodger);
        Arrays.sort(sortedLodgerService, comparator);
        return sortedLodgerService;
    }
}
